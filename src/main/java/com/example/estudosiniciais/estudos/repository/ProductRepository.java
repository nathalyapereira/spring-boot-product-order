package com.example.estudosiniciais.estudos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.estudosiniciais.estudos.entity.Product;

import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository  extends JpaRepository<Product,Long> {

    
}
