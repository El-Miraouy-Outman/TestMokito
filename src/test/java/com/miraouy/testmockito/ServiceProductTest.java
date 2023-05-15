package com.miraouy.testmockito;

import com.miraouy.testmockito.model.Product;
import com.miraouy.testmockito.repository.ProductRep;
import com.miraouy.testmockito.sevice.ServiceProductImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.testng.AssertJUnit.assertEquals;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class ServiceProductTest {

    @InjectMocks
    private ServiceProductImpl productService;

    @Mock
    private ProductRep productRep;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSave() {
        Product product = Product.builder()
                .id(1L)
                .name("HP")
                .price(4000)
                .qte(120)
                .build();
        when(productService.saveProduct(any(Product.class))).thenReturn(product);


    }


    @Test
    public void testFindById() {
        Product product = Product.builder()
                .id(1L)
                .name("HP ")
                .price(4000)
                .qte(120)
                .build();

        when(productRep.findById(1L)).thenReturn(Optional.ofNullable(product));

        Product result = productService.getProduct(1L);

        assertEquals("findById should return the sample Product object with ID 1", product, result);


    }


    @Test
    public void testIncome() {

        Product product = Product.builder()
                .id(1L)
                .name("HP ")
                .price(100)
                .qte(3)
                .build();

        when(productRep.findById(1L)).thenReturn(Optional.ofNullable(product));
        double income = productService.income(product.getId());
        assertEquals("Income() should return :  ", income,
                product.getPrice() * product.getQte());


    }

}

