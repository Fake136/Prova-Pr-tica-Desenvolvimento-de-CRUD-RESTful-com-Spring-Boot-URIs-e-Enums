package com.example.gerenciamento_crud.service;

import com.example.gerenciamento_crud.entity.Produtos;
import com.example.gerenciamento_crud.repository.ProdutosRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutosService {

    private final ProdutosRepository repository;

    public ProdutosService(ProdutosRepository repository) {
        this.repository = repository;
    }


    public Produtos salvar(Produtos produtos) {
        return repository.save(produtos);
    }


    public List<Produtos> listarTodos() {
        return repository.findAll();
    }


    public Optional<Produtos> buscarPorId(Long id) {
        return repository.findById(id);
    }


    public void deletar(Long id) {
        repository.deleteById(id);
    }


}