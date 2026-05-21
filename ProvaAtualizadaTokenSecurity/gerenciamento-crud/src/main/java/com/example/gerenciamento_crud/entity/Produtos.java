package com.example.gerenciamento_crud.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Entity
@Table(name = "tb_produtos")
@Data
public class Produtos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "nome_produto")
    private String nome;

    @NotBlank
    @Column(name = "descricao_produto")
    private String descricao;

    @Positive
    @Column(name = "preco_produto")
    private Double preco;

    @Column(name = "status_produto")
    private String status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}