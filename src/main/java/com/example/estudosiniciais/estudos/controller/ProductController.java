package com.example.estudosiniciais.estudos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.estudosiniciais.estudos.entity.Product;
import com.example.estudosiniciais.estudos.service.ProductService;




@RestController
@RequestMapping(value = "/api/store/product")
public class ProductController {
    
    @Autowired
    private ProductService service;


    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Long id) {
        Product product = service.findById(id);
        return ResponseEntity.ok().body(product);
    }


    @GetMapping("/get-all")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products =  service.findAll();
        return ResponseEntity.ok().body(products);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Product> editProduct(@PathVariable String id, @RequestBody Product product)  throws Exception{
        //TODO: process POST request
        product = service.save(product);
            
        return ResponseEntity.ok().body(product);
    }

    @PostMapping("save")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product) throws Exception{
        //TODO: process POST request
        product = service.save(product);            
        return ResponseEntity.ok().body(product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id){
        service.delete(id);
    }
    
}
