package com.miraouy.testmockito;

import com.miraouy.testmockito.model.Product;
import com.miraouy.testmockito.repository.ProductRep;
import com.miraouy.testmockito.sevice.ServiceProduct;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ServiceProductTest {
    @Mock
    private ServiceProduct productService;

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
        when(productService.saveProduct(any(Product.class))).thenReturn(product);
    }
}
