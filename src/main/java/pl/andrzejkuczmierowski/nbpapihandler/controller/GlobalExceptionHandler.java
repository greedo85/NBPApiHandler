package pl.andrzejkuczmierowski.nbpapihandler.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;


@RestControllerAdvice
public class GlobalExceptionHandler {
    @ResponseStatus(HttpStatus.BAD_REQUEST)

    @ExceptionHandler(MethodArgumentNotValidException.class)

    public String handleMethodArgumentInvalid(MethodArgumentNotValidException methodArgumentNotValidException) {
        return "Sorry, argument is incorrect: " + methodArgumentNotValidException.getMessage();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public String handleConstraintViolation(ConstraintViolationException constraintViolationException) {
        return "Sorry, constraint violated: " + constraintViolationException.getMessage();
    }

}
