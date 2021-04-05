package me.kimheesuk.memoapiserver.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ContorllerAdvice {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> allException(Exception e){
        String message = "failed request";

        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }
}
