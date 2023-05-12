package com.miraouy.testmockito.sevice;

import com.miraouy.testmockito.model.Product;
import com.miraouy.testmockito.repository.ProductRep;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service
public class ServiceProductImpl implements ServiceProduct {

    private final ProductRep productRep;
    @Override
    public Product saveProduct(Product product) {
       return  productRep.save(product);
    }

    @Override
    public Product getProduct(Long idProduct) {
        return productRep.findById(idProduct).orElse(null);
    }

    @Override
    public List<Product> getAllProduct() {
        return productRep.findAll();
    }

    @Override
    public void deleteProduct(Long idProduct) {
       productRep.deleteById(idProduct);
    }

    @Override
    public Product updateProduct(Long idProduct,Product product) {
        Product productFind=productRep.findById(idProduct).get();
        if(product==null) {
            System.out.println("this product not found");
        }
        Product product1=Product.builder()
                .price(product.getPrice())
                .name(product.getName())
                .qte(product.getQte())
                .build();
        productRep.save(product1);
        return product1;
    }
}
