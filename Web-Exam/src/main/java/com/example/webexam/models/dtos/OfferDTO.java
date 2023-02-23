package com.example.webexam.models.dtos;

import com.example.webexam.models.entities.Condition;
import com.example.webexam.models.enums.ConditionEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OfferDTO {

    @Size(min = 2, max = 50)
    @NotBlank
    private String description;

    @Positive
    private Double price;

    @NotNull
    private Condition condition;




}
