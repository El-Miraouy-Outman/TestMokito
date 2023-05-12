package com.miraouy.testmockito.controller;

import com.miraouy.testmockito.model.Product;
import com.miraouy.testmockito.sevice.ServiceProduct;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController  {
    private  final ServiceProduct serviceProduct;
    @PostMapping
    public Product saveProduct(Product product) {
    return  serviceProduct.saveProduct(product);
    }

    @GetMapping("/idProduct")
    public Product getProduct(Long idProduct) {
        return null;
    }

    @GetMapping
    public List<Product> getAllProduct() {
        return null;
    }

    @DeleteMapping("/idProduct")
    public void deleteProduct(Long idProduct) {

    }

    @PutMapping("/idProduct")
    public Product updateProduct(Long idProduct, Product product) {
        return null;
    }
}
