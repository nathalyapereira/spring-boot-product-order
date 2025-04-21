package com.example.estudosiniciais.estudos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.estudosiniciais.estudos.entity.Order;
import com.example.estudosiniciais.estudos.repository.OrderRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    public List<Order> findAll() {
        return repository.findAll();
    }

    public Order findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Order update(Long id, Order order) {
       Optional<Order> optionalOrder = repository.findById(id);

        if (optionalOrder.isEmpty()) {
            throw new RuntimeException("Order not found");
        }
        
        Order updateOrder  = optionalOrder.get();
        updateOrder.setEndereco(order.getEndereco());
        updateOrder.setStatus(order.getStatus());
        updateOrder.setDataPedido(order.getDataPedido());
        updateOrder.setProducts(order.getProducts());
        return repository.save(updateOrder);
    }

    public Order save(Order order){
        return repository.save(order);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    
    
}
