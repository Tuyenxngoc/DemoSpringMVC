package com.springmvc.demomvc.repositories;

import com.springmvc.demomvc.models.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, String> {
}
