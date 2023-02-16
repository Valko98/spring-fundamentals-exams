package com.example.shoppinglist.models.dtos;

import com.example.shoppinglist.models.Category;
import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddProductDTO {

    @Size(min = 3, max = 20)
    @NotBlank
    private String name;

    @Size(min = 5)
    private String description;

    @Positive
    private BigDecimal price;

    @FutureOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime neededBefore;

    @NotBlank
    private String category;

}
