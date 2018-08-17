package com.labsflix.bff.promotion.repository;

import com.labsflix.bff.domain.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PromotionRepository extends JpaRepository<Promotion, Integer> {

    Promotion findById(int id);

}