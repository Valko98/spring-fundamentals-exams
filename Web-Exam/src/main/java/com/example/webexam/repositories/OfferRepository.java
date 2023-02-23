package com.example.webexam.repositories;

import com.example.webexam.models.entities.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OfferRepository extends JpaRepository<Offer,Long> {
    Optional<Offer> findByDescription(String description);
}
