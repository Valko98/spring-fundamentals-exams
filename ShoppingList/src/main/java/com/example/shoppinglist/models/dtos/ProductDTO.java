package com.example.shoppinglist.models.dtos;

import com.example.shoppinglist.models.Category;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    @Size(min = 3, max = 20)
    private String name;

    @Size(min = 5)
    private String description;

    @Positive
    private int price;

    @FutureOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime neededBefore;

    @NotNull
    private Category category;

}
