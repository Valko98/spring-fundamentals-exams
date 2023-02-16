package com.example.shoppinglist.services;

import com.example.shoppinglist.models.Category;
import com.example.shoppinglist.models.Product;
import com.example.shoppinglist.models.User;
import com.example.shoppinglist.models.dtos.AddProductDTO;
import com.example.shoppinglist.models.dtos.ProductDTO;
import com.example.shoppinglist.models.enums.CategoryType;
import com.example.shoppinglist.repositories.UserRepository;
import com.example.shoppinglist.utils.LoggedUser;
import com.example.shoppinglist.repositories.CategoryRepository;
import com.example.shoppinglist.repositories.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private CategoryRepository categoryRepository;
    private final UserRepository userRepository;
    private final LoggedUser loggedUser;
    private final ModelMapper modelMapper;

    @Autowired
    public ProductService(ProductRepository productRepository,
                          CategoryRepository categoryRepository,
                          UserRepository userRepository,
                          LoggedUser loggedUser, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.userRepository = userRepository;
        this.loggedUser = loggedUser;
        this.modelMapper = modelMapper;
    }
    public boolean created(AddProductDTO addProductDTO) {
        Optional<Product> currentProduct = productRepository.findByName(addProductDTO.getName());
        if(currentProduct.isPresent()) {
            return false;

        }
        Optional<User> user = this.userRepository.findById(loggedUser.getId());

        if(user.isEmpty()) {
            return false;
        }
        CategoryType categoryType = CategoryType.valueOf(addProductDTO.getCategory());
        Category category = this.categoryRepository.findByCategoryType(categoryType);

        Product product = new Product();
        product.setName(addProductDTO.getName());
        product.setDescription(addProductDTO.getDescription());
        product.setNeededBefore(addProductDTO.getNeededBefore());
        product.setPrice(addProductDTO.getPrice());
        product.setUser(user.get());

        this.productRepository.save(product);
        return true;
    }
    public List<ProductDTO> getProductsByCategory(CategoryType categoryType) {
        Category category = categoryRepository.findByCategoryType(categoryType);

        return this.productRepository.findAllByCategoryAndUserId(category, loggedUser.getId())
                .stream()
                .map(ProductDTO::new)
                .collect(Collectors.toList());
    }

}
