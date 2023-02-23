package com.example.webexam.models.entities;

import com.example.webexam.models.enums.ConditionEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "conditions")
public class Condition extends BaseEntity {

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ConditionEnum name;

    @Column(nullable = false)
    private String description;

    @ManyToOne
    private Offer offer;

    public Condition(ConditionEnum conditionEnum) {
        this.name = conditionEnum;
    }

    public Condition(String description) {
        this.description = description;
    }

}
