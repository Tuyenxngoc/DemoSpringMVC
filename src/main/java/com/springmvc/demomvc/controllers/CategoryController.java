package com.springmvc.demomvc.controllers;

import com.springmvc.demomvc.models.Category;
import com.springmvc.demomvc.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path = "categories")
//http:localhost:8080/categories
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;

    //return name of "jsp file"
    //http:localhost:8083/categories
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getAllCategories(ModelMap modelMap) {
        Iterable<Category> categories = categoryRepository.findAll();
        modelMap.addAttribute("categories", categories);
        return "category";
    }
}