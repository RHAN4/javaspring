package com.senai.aula.controller;

import com.senai.aula.model.Usuario;
import com.senai.aula.repository.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    // Trazer informações do usuário:
    @GetMapping
    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    // Salvar usuário:
    @PostMapping
    public ResponseEntity<Usuario> salvar(@RequestBody Usuario usuario){
        usuarioRepository.save(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }

    // Alterar dados do  usuario:
    @PutMapping
    public ResponseEntity<Usuario> atualizar(@RequestBody Usuario usuario) {
        if (usuarioRepository.existsById(usuario.getId())) {
        usuarioRepository.save(usuario);
        }
        return ResponseEntity.ok().body(usuario);
    }

    // Deletar usuário:
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        usuarioRepository.deleteAllById(Collections.singleton(id));
        return ResponseEntity.noContent().build();
    }

}
