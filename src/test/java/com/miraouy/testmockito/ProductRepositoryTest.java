package com.miraouy.testmockito;

import com.miraouy.testmockito.model.Product;
import com.miraouy.testmockito.repository.ProductRep;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.testng.AssertJUnit.assertEquals;

@ExtendWith(MockitoExtension.class)
@SpringBootTest

public class ProductRepositoryTest {
    @Mock
    private ProductRep productRep;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSave() {
        Product product = Product.builder().id(1L).name("HP elite book").price(4000).qte(120).build();
        when(productRep.save(any(Product.class))).thenReturn(product);
    }

    @Test
    public void _testSave() {
        Product product = Product.builder()
                .id(1L)
                .name("HP")
                .price(4000)
                .qte(120)
                .build();
        when(productRep.save(any(Product.class))).thenReturn(product);
        Product savedProduct = productRep.save(product);
        verify(productRep).save(product);
        assertEquals("The saved product should have the same ID as the original product", product.getId(), savedProduct.getId());
        assertEquals("The saved product should have the same name as the original product", product.getName(), savedProduct.getName());
        assertEquals("The saved product should have the same price as the original product", product.getPrice(), savedProduct.getPrice());
        assertEquals("The saved product should have the same quantity as the original product", product.getQte(), savedProduct.getQte());
    }


    @Test
    public void testFindById() {
        Product product = Product.builder()
                .id(1L)
                .name("HP elite book")
                .price(4000)
                .qte(120)
                .build();
        // Optional.ofNullable(product) to handle NullPointerException exception -> findById()
        when(productRep.findById(1L)).thenReturn(Optional.ofNullable(product));

        Optional<Product> result = productRep.findById(1L);
        assertEquals("findById should return the sample Product object with ID 1", product, result.get());
    }


}
