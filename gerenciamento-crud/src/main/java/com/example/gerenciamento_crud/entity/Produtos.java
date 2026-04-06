package com.example.gerenciamento_crud.entity;

import jakarta.persistence.*;

@Entity(name = "Produtos")
@Table(name = "tb_Produtos")
public class Produtos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome-produto")
    private String Nome;

    @Column(name = "descricao-produto")
    private String Descrição;

    @Column(name = "preco-produto")
    private Integer Preço;

    @Column(name = "status-produto")
    private String Status;


    public Produtos() {}

    public Produtos(String nome, String Descrição, Integer curso, String status) {
        this.Nome = nome;
        this.Descrição = Descrição;
        this.Preço = curso;
        this.Status = status;
    }


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return Nome; }
    public void setNome(String nome) { this.Nome = nome; }

    public String getDescrição() { return Descrição; }
    public void setDescrição(String descrição) { this.Descrição = descrição; }

    public Integer getPreço() { return Preço; }
    public void setPreço(Integer preço) { this.Preço = preço; }

    public String getStatus() {       return Status;    }

    public void setStatus(String status) {        Status = status;    }
}