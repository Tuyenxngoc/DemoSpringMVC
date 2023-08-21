package com.springmvc.demomvc.controllers;

import com.springmvc.demomvc.models.Category;
import com.springmvc.demomvc.models.Product;
import com.springmvc.demomvc.repositories.CategoryRepository;
import com.springmvc.demomvc.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("products")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @RequestMapping(value = "/getProductsByCategoryID/{categoryID}", method = RequestMethod.GET)
    public String getProductsByCategoryID(ModelMap modelMap, @PathVariable String categoryID) {
        Iterable<Product> products = productRepository.findByCategoryID(categoryID);
        modelMap.addAttribute("products", products);
        return "productList";
    }

    @RequestMapping(value = "/changeCategory/{productID}", method = RequestMethod.GET)
    public String changeCategory(ModelMap modelMap, @PathVariable String productID) {
        Iterable<Category> categories = categoryRepository.findAll();
        Optional<Product> product = productRepository.findById(productID);
        modelMap.addAttribute("product", product.get());
        modelMap.addAttribute("categories", categories);
        return "updateProduct";
    }

    @RequestMapping(value = "/updateProduct/{productID}", method = RequestMethod.POST)
    public String updateProduct(ModelMap modelMap,
                                @Valid @ModelAttribute("product") Product product,
                                BindingResult bindingResult,
                                @PathVariable String productID
    ) {
        Iterable<Category> categories = categoryRepository.findAll();
        if (bindingResult.hasErrors()) {
            modelMap.addAttribute("categories", categories);
            return "updateProduct";//updateProduct.jsp
        }
        try {
            if (productRepository.findById(productID).isPresent()) {
                Product foundProduct = productRepository
                        .findById(product.getProductID()).get();
                if (!product.getProductName().trim().isEmpty()) {
                    foundProduct.setProductName(product.getProductName());
                }
                if (!product.getCategoryID().isEmpty()) {
                    foundProduct.setCategoryID(product.getCategoryID());
                }
                //is empty => "" OR NULL
                if (!product.getDescription().trim().isEmpty()) {
                    foundProduct.setDescription(product.getDescription());
                }
                if (product.getPrice() > 0) {
                    foundProduct.setPrice(product.getPrice());
                }
                productRepository.save(foundProduct);
            }
        } catch (Exception e) {
            return "updateProduct";//updateProduct.jsp
        }
        return "redirect:/products/getProductsByCategoryID/" + product.getCategoryID();
    }

}
