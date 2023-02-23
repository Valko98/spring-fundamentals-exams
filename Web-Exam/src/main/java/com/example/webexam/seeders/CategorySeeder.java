package com.example.webexam.seeders;

import com.example.webexam.models.entities.Condition;
import com.example.webexam.models.enums.ConditionEnum;
import com.example.webexam.repositories.ConditionRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class CategorySeeder {

    private final ConditionRepository conditionRepository;

    public CategorySeeder(ConditionRepository conditionRepository) {
        this.conditionRepository = conditionRepository;

    }

    @PostConstruct
    public void initializeCategories() {
        if (conditionRepository.count() == 0) {
            Condition excellent = new Condition();
            excellent.setName(ConditionEnum.EXCELLENT);
            excellent.setDescription("In perfect condition");

            Condition good = new Condition();
            good.setName(ConditionEnum.GOOD);
            good.setDescription("Some signs of wear and tear of minor defects");

            Condition acceptable = new Condition();
            acceptable.setName(ConditionEnum.ACCEPTABLE);
            acceptable.setDescription("The item is fairly worn but continues to function properly");

            conditionRepository.saveAll(Arrays.asList(excellent,good,acceptable));

        }
    }
}