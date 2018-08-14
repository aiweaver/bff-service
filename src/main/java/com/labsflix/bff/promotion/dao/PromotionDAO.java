package com.labsflix.bff.promotion.dao;

import com.labsflix.bff.contents.vo.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository("promotionDAO")
public class PromotionDAO {

	@Autowired
	private RestTemplate restTemplate;

	@Value("${api.connect.path}")
	private String apic;

	@Value("${api.services.recommendation-service}")
	private String serviceUrl;

	public Content getPromotion() {
		return restTemplate.getForObject(String.format("%s/v1/promotions", serviceUrl), Content.class);
    }
}