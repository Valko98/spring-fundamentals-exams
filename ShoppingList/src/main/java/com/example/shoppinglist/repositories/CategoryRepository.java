package com.example.shoppinglist.repositories;

import com.example.shoppinglist.models.Category;
import com.example.shoppinglist.models.enums.CategoryType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {


    Category findByCategoryType(CategoryType categoryType);
}
