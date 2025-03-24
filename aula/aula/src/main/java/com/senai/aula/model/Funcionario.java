package com.senai.aula.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tab_funcionario")

public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String cpf;
    private String rg;
    private String matricula;
    private String setor;
    private String salario;

    public Funcionario() {
    }

    public Funcionario(Long id, String cpf, String rg, String matricula, String setor, String salario) {
        this.id = id;
        this.cpf = cpf;
        this.rg = rg;
        this.matricula = matricula;
        this.setor = setor;
        this.salario = salario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Funcionário: " +
                "ID: " + id +
                ", CPF: '" + cpf + '\'' +
                ", RG: '" + rg + '\'' +
                ", matricula: '" + matricula + '\'' +
                ", setor: '" + setor + '\'' +
                ", salário: '" + salario + '\'';
    }
}
