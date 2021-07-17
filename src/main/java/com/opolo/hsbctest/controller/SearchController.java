package com.opolo.hsbctest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.opolo.hsbctest.model.CityModel;
import com.opolo.hsbctest.services.SearchService;

@RestController
@RequestMapping(value = "/api/v1")
public class SearchController {

	@Autowired
	private SearchService searchDataService;
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping(value = "/cities")
	public List<CityModel> searchPage() {
		return searchDataService.getCitiesDataList();
		
	}

}
