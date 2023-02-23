package com.example.webexam.services;

import com.example.webexam.models.dtos.OfferDTO;
import com.example.webexam.models.entities.Condition;
import com.example.webexam.models.entities.Offer;
import com.example.webexam.models.enums.ConditionEnum;
import com.example.webexam.repositories.ConditionRepository;
import com.example.webexam.repositories.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OfferService {
   private final OfferRepository offerRepository;
   private final ConditionRepository conditionRepository;

   @Autowired
    public OfferService(OfferRepository offerRepository, ConditionRepository conditionRepository) {
        this.offerRepository = offerRepository;
       this.conditionRepository = conditionRepository;
   }

    public void created(OfferDTO offerDTO) {


        Offer offer = new Offer();
        offer.setDescription(offerDTO.getDescription());
        offer.setPrice(offerDTO.getPrice());
        offer.setCondition(offerDTO.getCondition());

        this.offerRepository.save(offer);
    }

}
