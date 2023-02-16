package com.example.shoppinglist.repositories;

import com.example.shoppinglist.models.Category;
import com.example.shoppinglist.models.Product;
import com.example.shoppinglist.models.dtos.ProductDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByName(String name);

    List<ProductDTO> findAllByCategoryAndUserId(Category category, long id);
}
