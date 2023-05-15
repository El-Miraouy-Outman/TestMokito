package com.miraouy.testmockito.sevice;

import com.miraouy.testmockito.model.Product;

import java.util.List;

public interface ServiceProduct {
    public Product saveProduct(Product product);

    public Product getProduct(Long idProduct);

    public List<Product> getAllProduct();

    public void deleteProduct(Long idProduct);

    public Product updateProduct(Long idProduct, Product product);

    public double income(Long id);


}
