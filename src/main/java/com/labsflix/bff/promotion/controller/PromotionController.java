package com.labsflix.bff.promotion.controller;

import com.labsflix.bff.contents.vo.Content;
import com.labsflix.bff.promotion.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class PromotionController {
	
	@Autowired
	private PromotionService promotionService;
 
	@RequestMapping(path="/promotions", method=RequestMethod.GET, name="getPromotion")
	public Content getPromotions() {
		Content promotion = promotionService.getPromotion();
		return promotion;
	}
}
