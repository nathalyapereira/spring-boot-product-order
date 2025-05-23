package com.example.estudosiniciais.estudos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.estudosiniciais.estudos.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{
    
}
