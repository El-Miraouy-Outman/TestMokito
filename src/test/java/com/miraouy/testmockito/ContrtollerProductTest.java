package com.miraouy.testmockito;


import com.miraouy.testmockito.controller.ProductController;
import com.miraouy.testmockito.model.Product;
import com.miraouy.testmockito.sevice.ServiceProduct;
import com.miraouy.testmockito.sevice.ServiceProductImpl;
import org.junit.Test;

import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.List;


@WebMvcTest(controllers = ProductController.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class ContrtollerProductTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ServiceProduct serviceProduct;


    private List<Product> products;

    @BeforeEach
    void setUp() {
       // MockitoAnnotations.initMocks(this); // initialize mocks

        this.products = new ArrayList<>();
        this.products.add(new Product(1L, "PC", 5000, 10));
        this.products.add(new Product(2L, "Cellphone", 4000, 8));
        this.products.add(new Product(3L, "PS5", 8000, 9));
        Mockito.when(serviceProduct.getAllProduct()).thenReturn(products);
    }


    @Test
    public void shouldAllProducts() throws Exception {






        this.mockMvc.perform(get("/api/products"))
                .andExpect(status().isOk())
               // .andExpect(content().contentType(TestUtil.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.size()", is(products.size())))
                ;

        verify(serviceProduct, times(1)).getAllProduct();
        verifyNoInteractions(serviceProduct);
    }

}
