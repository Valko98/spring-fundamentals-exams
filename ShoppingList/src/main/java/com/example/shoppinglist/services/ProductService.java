package com.example.shoppinglist.services;

import com.example.shoppinglist.utils.LoggedUser;
import com.example.shoppinglist.repositories.CategoryRepository;
import com.example.shoppinglist.repositories.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private CategoryRepository categoryRepository;
    private final LoggedUser loggedUser;

    public ProductService(ProductRepository productRepository,
                          CategoryRepository categoryRepository,
                          LoggedUser loggedUser) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.loggedUser = loggedUser;
    }

}
