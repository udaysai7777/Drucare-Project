package com.example.demo.Cinema.Resource;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.Cinema.Model.CatalogMenu;

public class MovieCatalog{
	@Autowired 
	RestTemplate restTemplate;
	@RequestMapping("/catalog/{userId}")
	public List<CatalogMenu> getCatalog(@PathVariable("userId") String userId){

		return Collections.singletonList(new CatalogMenu("RRR","Revolution", 4));
	}
}

	
	
	
	
	
	

