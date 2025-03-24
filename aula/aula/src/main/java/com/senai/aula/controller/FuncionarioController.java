package com.senai.aula.controller;

import com.senai.aula.model.Funcionario;
import com.senai.aula.model.Usuario;
import com.senai.aula.repository.FuncionarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

    private FuncionarioRepository funcionarioRepository;

    public  FuncionarioController(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    @GetMapping
    public List<Funcionario> listarTodos() {
        return funcionarioRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Funcionario> salvar(@RequestBody Funcionario funcionario) {
        funcionarioRepository.save(funcionario);
        return ResponseEntity.status(HttpStatus.CREATED).body(funcionario);
    }

    @PutMapping
    public  ResponseEntity<Funcionario> atualizar(@RequestBody Funcionario funcionario) {
        if (funcionarioRepository.existsById(funcionario.getId())) {
            funcionarioRepository.save((funcionario));
        }
        return ResponseEntity.ok().body(funcionario);
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<Void> excluir (@PathVariable Long id) {
        funcionarioRepository.deleteAllById(Collections.singleton(id));
        return ResponseEntity.noContent().build();
    }
}
