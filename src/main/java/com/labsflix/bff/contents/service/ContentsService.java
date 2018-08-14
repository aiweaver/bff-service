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
	
	@Autowired
	private ContentsDAO contentsDAO;
	
	@Autowired
	private EpisodeDAO episodeDAO;
	
	@Autowired
	private TrailerDAO trailerDAO;

	public List<Content> getContentsByCategory(String category) {
		List<Content> contents = contentsDAO.getContentsByCategory(category);
		return contents;
	}
	
	public List<Content> getContentsByTitle(String title) {
		List<Content> contents = contentsDAO.getContentsByTitle(title);
		return contents;
	}
	
	public Content getContentsDetail(String id) {
		Content content = contentsDAO.getContentsDetail(id);
		return content;
	}
	
	public List<Season> getAllEpisodes(String id) {
		List<Season> seasons = episodeDAO.getAllEpisodes(id);
		return seasons;
	}
	
	public List<Trailer> getTrailers(String id) {
		List<Trailer> trailers = trailerDAO.getTrailers(id);
		return trailers;
	}
	
	public List<Content> getSmiliars(String id, String category) {
		Content content = this.getContentsDetail(id);
		List<Content> similars = new ArrayList<Content>(getContentsByCategory(category));
		similars.remove(content);
		return similars;
	}
}
