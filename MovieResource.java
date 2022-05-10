package io.drucare.movieinfoservice.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.drucare.movieinfoservice.Model.Movie;
@RestController
public class MovieResource {
	
	@RequestMapping("/movies/{movieId}")
	public Movie getMovieInfo(@PathVariable("movieId") String movieId){
		return new Movie(movieId,"Test name");
	}
}
