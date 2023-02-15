package com.example.shoppinglist.seeders;


import com.example.shoppinglist.models.Category;
import com.example.shoppinglist.models.enums.CategoryType;
import com.example.shoppinglist.repositories.CategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;


@Component
public class CategorySeeder implements CommandLineRunner {
    private final CategoryRepository categoryRepository;

    public CategorySeeder(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        if(this.categoryRepository.count() == 0) {
            List<Category> categories = Arrays.stream(CategoryType.values())
                    .map(Category::new).toList();

            this.categoryRepository.saveAll(categories);
        }
    }
}
