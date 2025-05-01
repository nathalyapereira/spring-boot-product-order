package com.example.estudosiniciais.estudos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.estudosiniciais.estudos.entity.Product;
import com.example.estudosiniciais.estudos.exception.ProductNullException;
import com.example.estudosiniciais.estudos.exception.ProductPriceException;
import com.example.estudosiniciais.estudos.repository.ProductRepository;

@Service
public class ProductService {
    
    @Autowired
    private ProductRepository repository;

    public Product save(Product product) throws Exception{
        if(product.getNome() == null || product.getPreco() == null)
            throw new ProductNullException();

        if(product.getPreco() < 0)
            throw new ProductPriceException("Invalid price");
        return repository.save(product);
    }

    public Product findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<Product> findAll() {
        return repository.findAll();
    }

    public Product update(Long id, Product product ) throws Exception{
        Optional<Product> optionalProduct = repository.findById(id);
        
        if (optionalProduct.isEmpty()) {
            throw new RuntimeException("Product not found");
        }
        if(product.getNome() == null || product.getPreco() == null)
            throw new ProductNullException();

        if(product.getPreco() < 0)
            throw new ProductPriceException("Invalid price");
        
        Product updateProduct  = optionalProduct.get();
        updateProduct.setNome(product.getNome());
        updateProduct.setDescricao(product.getDescricao());
        updateProduct.setPreco(product.getPreco());
        return repository.save(updateProduct);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }
}
