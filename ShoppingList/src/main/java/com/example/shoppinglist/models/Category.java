package com.example.shoppinglist.models;

import com.example.shoppinglist.models.enums.CategoryType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(unique = true)
    private CategoryType categoryType;

    @Column(columnDefinition = "TEXT")
    private String description;

    public Category(CategoryType categoryType) {
        this.categoryType = categoryType;
        this.description = categoryType.toString();
    }
}
