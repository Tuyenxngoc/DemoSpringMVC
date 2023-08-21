package com.springmvc.demomvc.repositories;

import com.springmvc.demomvc.models.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, String> {
    Iterable<Product> findByCategoryID(String categoryID);
}
