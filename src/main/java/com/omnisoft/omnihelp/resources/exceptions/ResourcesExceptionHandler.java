package com.omnisoft.omnihelp.resources.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.omnisoft.omnihelp.services.exceptions.DataIntegrityViolationException;
import com.omnisoft.omnihelp.services.exceptions.ObjectNotFoundException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;

@ControllerAdvice
public class ResourcesExceptionHandler {

    // Tratamento de objeto não encontrado
    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectnotFoundException(ObjectNotFoundException ex,
            HttpServletRequest request) {

        StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(),
                "Object Not Found", ex.getMessage(), request.getRequestURI());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    // Tratamento de violação de dados
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<StandardError> dataIntegrityViolationException(DataIntegrityViolationException ex,
            HttpServletRequest request) {

        StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(),
                "Violation Data", ex.getMessage(), request.getRequestURI());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    // Tratamento de campos não preenchidos
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> validationErrors(MethodArgumentNotValidException ex,
            HttpServletRequest request) {

        ValidationError errors = new ValidationError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(),
                "Validation error", "Erro na validação dos campos", request.getRequestURI());

        // Percorre a lista de erros e adiciona o nome do erro e a mensagem
        for (FieldError e : ex.getBindingResult().getFieldErrors()) {
            errors.addError(e.getField(), e.getDefaultMessage());
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }

    // Tratamento de CPF iválido
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<StandardError> constraintViolationException(ConstraintViolationException ex,
            HttpServletRequest request) {

        StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(),
                "Information invalid", "Número do registro de contribuinte individual brasileiro (CPF) inválido",
                request.getRequestURI());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

}