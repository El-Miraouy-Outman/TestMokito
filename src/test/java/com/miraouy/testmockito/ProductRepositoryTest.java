package com.miraouy.testmockito;

import com.miraouy.testmockito.model.Product;
import com.miraouy.testmockito.repository.ProductRep;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static  org.mockito.Mockito.when;
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
public void testSave(){
        Product product=Product.builder()
                .id(1L)
                .name("HP ellit")
                .price(4000)
                .qte(120)
                .build();
        when(productRep.save(any(Product.class))).thenReturn(product);
    }


}
