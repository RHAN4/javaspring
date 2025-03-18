package com.senai.projeto.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tab_funcionario")
@Data
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;
    private String matricula;
    private String email;
}
