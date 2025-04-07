package com.senai.atividade1.controller;

import com.senai.atividade1.model.Funcionario;
import com.senai.atividade1.service.FuncionarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    private FuncionarioService funcionarioService;

    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @GetMapping
    public List<Funcionario> listarTodos() {
        return funcionarioService.listarTodos();
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> salvar(@Valid @RequestBody Funcionario funcionario) {
        funcionarioService.salvar(funcionario);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of("mensagem: ", "Funcionário cadastrado com sucesso"));
    }

    @PutMapping
    public ResponseEntity<Map<String, Object>> atualizar(@RequestBody Funcionario funcionario) {
        funcionarioService.atualizar(funcionario);
        return ResponseEntity.status(HttpStatus.OK)
                .body(Map.of("mensagem: ", "Dados do funcionário atualizados com sucesso"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> excluir(@PathVariable Long id) {
        funcionarioService.excluir(id);
        return ResponseEntity
                .ok()
                .body(Map.of("mensagem: ", "Dados do funcionário excluído com sucesso"));
    }
}
