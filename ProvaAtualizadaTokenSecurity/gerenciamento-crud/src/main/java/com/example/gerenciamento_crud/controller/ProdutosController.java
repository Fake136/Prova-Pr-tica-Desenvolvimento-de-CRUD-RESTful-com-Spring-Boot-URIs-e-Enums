package com.example.gerenciamento_crud.controller;

import com.example.gerenciamento_crud.entity.Produtos;
import com.example.gerenciamento_crud.service.ProdutosService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Produto")
public class ProdutosController {

    private final ProdutosService service;

    public ProdutosController(ProdutosService service) {
        this.service = service;
    }

    @PostMapping
    public Produtos criar(@RequestBody Produtos produtos) {
        return service.salvar(produtos);
    }

    @GetMapping
    public List<Produtos> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produtos> buscar(@PathVariable Long id) {
        Optional<Produtos> livro = service.buscarPorId(id);
        return livro.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Produtos> atualizar(
            @PathVariable Long id,
            @RequestBody Produtos produtos) {

        Produtos atualizado = service.atualizar(id, produtos);

        return ResponseEntity.ok(atualizado);
    }
}