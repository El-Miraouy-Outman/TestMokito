package com.miraouy.testmockito.repository;

import com.miraouy.testmockito.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRep extends JpaRepository<Product,Long> {

}
