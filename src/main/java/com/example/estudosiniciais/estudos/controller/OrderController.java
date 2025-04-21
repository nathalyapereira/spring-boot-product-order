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

import com.example.estudosiniciais.estudos.entity.Order;
import com.example.estudosiniciais.estudos.service.OrderService;

@RestController
@RequestMapping(value = "/api/store/order")
public class OrderController {
    
    
    @Autowired
    private OrderService service;


    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrder(@PathVariable Long id) {
        Order order = service.findById(id);
        return ResponseEntity.ok().body(order);
    }


    @GetMapping("/get-all")
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders =  service.findAll();
        return ResponseEntity.ok().body(orders);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Order> editOrder(@PathVariable String id, @RequestBody Order order)  throws Exception{
        //TODO: process POST request
        order = service.save(order);
            
        return ResponseEntity.ok().body(order);
    }

    @PostMapping("save")
    public ResponseEntity<Order> saveOrder(@RequestBody Order order) throws Exception{
        //TODO: process POST request
        order = service.save(order);

        return ResponseEntity.ok().body(order);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id){
        service.delete(id);
    }
}
