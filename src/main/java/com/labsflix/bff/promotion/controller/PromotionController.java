package com.labsflix.bff.promotion.controller;

import com.labsflix.bff.domain.Content;
import com.labsflix.bff.promotion.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class PromotionController {

	private PromotionService promotionService;

	@Autowired
	public PromotionController(PromotionService promotionService) {
		this.promotionService = promotionService;
	}

	@GetMapping("/promotions")
	public Content getPromotions() {
		return promotionService.getPromotion();
	}
}
