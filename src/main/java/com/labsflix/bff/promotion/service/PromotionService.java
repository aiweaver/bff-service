package com.labsflix.bff.promotion.service;

import com.labsflix.bff.contents.vo.Content;
import com.labsflix.bff.promotion.dao.PromotionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("promotionService")
public class PromotionService {
	
	@Autowired
	private PromotionDAO promotionDAO;
	
	public Content getPromotion() {
		Content promotion = promotionDAO.getPromotion();
		return promotion;
	}
	
}
