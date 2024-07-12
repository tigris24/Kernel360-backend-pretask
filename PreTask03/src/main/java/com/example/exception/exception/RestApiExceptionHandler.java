package com.example.exception.exception;

import com.example.exception.Controller.RestApiBController;
import com.example.exception.Controller.RestApiController;
import com.example.exception.Model.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@Slf4j
//@RestControllerAdvice(basePackages = "com.example.exception.Controller")
@RestControllerAdvice(basePackageClasses = {RestApiController.class, RestApiBController.class})
@Order(1)
public class RestApiExceptionHandler {

    @ExceptionHandler(value = {IndexOutOfBoundsException.class})
    public ResponseEntity outOfBound(IndexOutOfBoundsException ex) {
        log.error("IndexOutOfBoundsException", ex);
        return ResponseEntity.status(200).build();
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<Api> noSuchElementException(NoSuchElementException ex) {
        log.error("NoSuchElementException", ex);
        var Response = Api.builder()
                .resultCode(String.valueOf(HttpStatus.NOT_FOUND.value()))
                .resultMessage(HttpStatus.NOT_FOUND.getReasonPhrase())
                .build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Response);
    }


}
