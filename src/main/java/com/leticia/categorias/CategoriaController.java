package com.leticia.categorias;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepository repository;

    @Autowired
    private CategoriaProducer producer;

    @GetMapping
    public List<Categoria> listarTodas() {
        return repository.findAll();
    }

    @PostMapping
    public Categoria criar(@RequestBody Categoria categoria) {
        Categoria categoriaSalva = repository.save(categoria);

        // Enviar mensagem para o RabbitMQ
        String mensagem = "Categoria criada com id: " + categoriaSalva.getId() + " e nome: " + categoriaSalva.getNome();
        producer.enviarMensagem(mensagem);

        return categoriaSalva;
    }

    @PutMapping("/{id}")
    public Categoria atualizar(@PathVariable Long id, @RequestBody Categoria novaCategoria) {
        Optional<Categoria> categoriaExistente = repository.findById(id);
        if (categoriaExistente.isPresent()) {
            Categoria categoria = categoriaExistente.get();
            categoria.setNome(novaCategoria.getNome());
            return repository.save(categoria);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Categoria com id " + id + " não encontrada.");
        }
    }

    @DeleteMapping("/{id}")
    public String deletar(@PathVariable Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return "Categoria com id " + id + " foi deletada com sucesso.";
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Categoria com id " + id + " não encontrada.");
        }
    }
}
