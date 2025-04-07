package com.senai.atividade1.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;

@Entity
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double salario;

    @NotBlank(message = "Nome é obrigatorio")
    private String nome;

    @NotBlank(message = "E-mail é obrigatório.")
    @Email(message = "Deve ser um e-mail valido.")
    private String email;

    @Enumerated(EnumType.STRING)
    private Genero genero;

    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;

    public Funcionario() {
    }

    public Funcionario(Long id, double salario, String nome, String email, Genero genero, Endereco endereco) {
        this.id = id;
        this.salario = salario;
        this.nome = nome;
        this.email = email;
        this.genero = genero;
        this.endereco = endereco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public @NotBlank(message = "Nome é obrigatorio") String getNome() {
        return nome;
    }

    public void setNome(@NotBlank(message = "Nome é obrigatorio") String nome) {
        this.nome = nome;
    }

    public @NotBlank(message = "E-mail é obrigatório.") @Email(message = "Deve ser um e-mail valido.") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "E-mail é obrigatório.") @Email(message = "Deve ser um e-mail valido.") String email) {
        this.email = email;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Funcionário: " +
                "ID: " + id +
                ", nome: '" + nome + '\'' +
                ", email: '" + email + '\'' +
                ", gênero: " + genero +
                ", salário: " + salario +
                ", endereço: " + endereco;
    }
}
