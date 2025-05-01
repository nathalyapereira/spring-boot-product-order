package com.example.estudosiniciais.estudos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.estudosiniciais.estudos.entity.Product;
import com.example.estudosiniciais.estudos.exception.ProductPriceException;
import com.example.estudosiniciais.estudos.service.ProductService;

@SpringBootTest
public class ProductTest {

    @Autowired
    private ProductService productService;
    
    @Test
    public void checkProductValueIsNegative() throws Exception{
        Product product = new Product();

        product.setNome("Test Product");
        product.setPreco(-10.2);

        ProductPriceException exception = assertThrows(ProductPriceException.class, () -> productService.save(product));

        assertEquals("Invalid price", exception.getMessage());


    }
}
