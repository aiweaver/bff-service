package com.labsflix.bff.contents.controller;

import java.util.List;

import com.labsflix.bff.contents.service.ContentsService;
import com.labsflix.bff.contents.vo.Content;
import com.labsflix.bff.contents.vo.Season;
import com.labsflix.bff.contents.vo.Trailer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class ContentsController {

	private ContentsService contentsService;

	@Autowired
	public ContentsController(ContentsService contentsService) {
		this.contentsService = contentsService;
	}

	@GetMapping("/contents")
	public List<Content> getContents(@RequestParam(value = "category") String category) {
		return contentsService.getContentsByCategory(category);
	}
	
	@GetMapping("/contents/search")
	public List<Content> searchContents(@RequestParam(value = "title") String title) {
		return contentsService.getContentsByTitle(title);
	}
	
	@GetMapping("/contents/{id}")
	public Content getContentsDetail(@PathVariable(value = "id") String id) {
		return contentsService.getContentsDetail(id);
	}
	
	@GetMapping("/contents/{id}/episodes")
	public List<Season> getAllEpisodes(@PathVariable(value = "id") String id) {
		return contentsService.getAllEpisodes(id);
	}
	
	@GetMapping("/contents/{id}/trailers")
	public List<Trailer> getTrailers(@PathVariable(value = "id") String id) {
		return contentsService.getTrailers(id);
	}
	
	@GetMapping("/contents/{id}/similars")
	public List<Content> getSimilars(@PathVariable(value = "id") String id, @RequestParam(value = "category") String category) {
		return contentsService.getSmiliars(id, category);
	}

}
