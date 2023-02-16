package com.example.shoppinglist.models.dtos;

import com.example.shoppinglist.models.Product;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProductDTO {
    private long id;
    private String name;
    private BigDecimal price;


    public ProductDTO(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.price = product.getPrice();
    }

    public ProductDTO(ProductDTO productDTO) {

    }

    @Override
    public String toString() {
        return String.format("Name: %s Price: %.2f lv", name, price);
    }

}
