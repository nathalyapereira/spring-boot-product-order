package com.example.estudosiniciais.estudos.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.estudosiniciais.estudos.exception.ProductNullException;
import com.example.estudosiniciais.estudos.exception.ProductPriceException;

@ControllerAdvice
public class ProductControllerAdvice extends ResponseEntityExceptionHandler{

    @ExceptionHandler(ProductNullException.class)
    public ResponseEntity<Object> catErroNull() {
        Map<String, Object> body = new HashMap<String, Object>();
        body.put("message", "Check the fields of the product");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }

    @ExceptionHandler(ProductPriceException.class)
    public ResponseEntity<Object> catErroPrice() {
        Map<String, Object> body = new HashMap<String, Object>();
        body.put("message", "Check the price of the product");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }
}
