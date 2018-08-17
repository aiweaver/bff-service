package com.labsflix.bff.promotion.service;

import com.labsflix.bff.domain.Content;
import com.labsflix.bff.domain.Promotion;
import com.labsflix.bff.promotion.repository.PromotionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("promotionService")
public class PromotionService {

	@Value("${api.services.recommendation-service}")
	private String serviceUrl;

	@Value("${api.services.contents-service}")
	private String contentsServiceUrl;

	private RestTemplate restTemplate;

	private PromotionRepository promotionRepository;

	@Autowired
	public PromotionService(RestTemplate restTemplate, PromotionRepository promotionRepository) {
		this.restTemplate = restTemplate;
		this.promotionRepository = promotionRepository;
	}

	public Content getPromotion() {
		Content promotion;
		try {
			promotion = restTemplate.getForObject(String.format("%s/v1/promotions", serviceUrl), Content.class);
		} catch (Exception e) {
			Promotion defaultPromotion = promotionRepository.findById(1);
			promotion = restTemplate.getForObject(String.format("%s/v1/contents/%s", contentsServiceUrl, defaultPromotion.getContent()), Content.class);
		}
		return promotion;
	}
	
}
