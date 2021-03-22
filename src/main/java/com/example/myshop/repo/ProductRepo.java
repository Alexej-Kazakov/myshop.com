package com.example.myshop.repo;

import com.example.myshop.domain.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepo extends CrudRepository<Product, Long> {

   List<Product> findByProductName(String productName);

}
