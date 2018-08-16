package com.labsflix.bff.contents.service;

import java.util.ArrayList;
import java.util.List;

import com.labsflix.bff.contents.dao.ContentsDAO;
import com.labsflix.bff.contents.dao.EpisodeDAO;
import com.labsflix.bff.contents.dao.TrailerDAO;
import com.labsflix.bff.contents.vo.Content;
import com.labsflix.bff.contents.vo.Season;
import com.labsflix.bff.contents.vo.Trailer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("contentsService")
public class ContentsService {

	private ContentsDAO contentsDAO;

	private EpisodeDAO episodeDAO;

	private TrailerDAO trailerDAO;

	@Autowired
	public ContentsService(ContentsDAO contentsDAO, EpisodeDAO episodeDAO, TrailerDAO trailerDAO) {
		this.contentsDAO = contentsDAO;
		this.episodeDAO = episodeDAO;
		this.trailerDAO = trailerDAO;
	}

	public List<Content> getContentsByCategory(String category) {
		return contentsDAO.getContentsByCategory(category);
	}
	
	public List<Content> getContentsByTitle(String title) {
		return contentsDAO.getContentsByTitle(title);
	}
	
	public Content getContentsDetail(String id) {
		return contentsDAO.getContentsDetail(id);
	}
	
	public List<Season> getAllEpisodes(String id) {
		return episodeDAO.getAllEpisodes(id);
	}
	
	public List<Trailer> getTrailers(String id) {
		return trailerDAO.getTrailers(id);
	}
	
	public List<Content> getSmiliars(String id, String category) {
		Content content = this.getContentsDetail(id);
		List<Content> similars = new ArrayList<>(getContentsByCategory(category));
		similars.remove(content);
		return similars;
	}
}
