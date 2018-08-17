package com.labsflix.bff.promotion.dao;

import com.labsflix.bff.contents.vo.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository("promotionDAO")
public class PromotionDAO {

	private RestTemplate restTemplate;

	@Autowired
	public PromotionDAO(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@Value("${api.services.recommendation-service}")
	private String serviceUrl;

	@Value("${api.services.contents-service}")
	private String contentsServiceUrl;

	public Content getPromotion() {
		Content promotion;
		try {
			promotion = restTemplate.getForObject(String.format("%s/v1/promotions", serviceUrl), Content.class);
		} catch (Exception e) {
			promotion = restTemplate.getForObject(String.format("%s/v1/contents/62", contentsServiceUrl), Content.class);
		}
		return promotion;
    }
}