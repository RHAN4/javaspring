package com.senai.atividade1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
  @ExceptionHandler(IllegalArgumentException.class)
  public ResponseEntity<Map<String, Object>> handlerIllegalArgument(IllegalArgumentException erro) {
    return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(Map.of("erro", erro.getMessage()));
  }

  @ExceptionHandler (EmailJaCadastradoException.class)
  public ResponseEntity<Map<String, Object>> handlerEmailJaCadastrado(EmailJaCadastradoException erro) {
    return ResponseEntity
            .status(HttpStatus.CONFLICT)
            .body(Map.of("erro", erro.getMessage()));
  }

  @ExceptionHandler (MethodArgumentNotValidException.class)
  public ResponseEntity<Map<String, Object>> handlerMethodArgumentNotValidException(MethodArgumentNotValidException erro) {
    return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(Map.of("mensagem", erro.getFieldErrors().get(0).getDefaultMessage()));
  }

  @ExceptionHandler(NoResourceFoundException.class)
  public ResponseEntity<Map<String, Object>> handlerNoResourceFoundException(NoResourceFoundException erro) {
    return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body(Map.of("mensagem", "Recurso não encontrado."));
  }

  @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
  public ResponseEntity<Map<String, Object>> handlerHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException erro) {
    return ResponseEntity
            .status(HttpStatus.METHOD_NOT_ALLOWED)
            .body(Map.of("mensagem", "Método não suportado."));
  }
}
