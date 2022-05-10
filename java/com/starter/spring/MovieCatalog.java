package io.drucare.moviecatalogservice.Resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.Builder;

import io.drucare.moviecatalogservice.Model.CatalogMenu;
import io.drucare.moviecatalogservice.Model.Movie;
import io.drucare.moviecatalogservice.Model.Rating;
import io.drucare.moviecatalogservice.Model.UserRating;

@RestController
public class MovieCatalog {
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private WebClient.Builder webClientBuilder;
	
	
	
	@RequestMapping("/catalog/{userId}")
	public List<CatalogMenu> getCatalog(@PathVariable("userId") String userId){
		
		UserRating ratings=restTemplate.getForObject("http://localhost:8083/ratingsdata/users/"+ userId,UserRating.class);
		return ratings.getUserRating().stream().map(rating -> {
		      Movie movie=restTemplate.getForObject("http://localhost:8083/movies/" +rating.getMovieId(),Movie.class);
		      
		      return new CatalogMenu(movie.getName(),"Desc",rating.getRating());
		      })
				.collect(Collectors.toList());
	
		
		
		
		
		//	WebClient.Builder builder=WebClient.builder();
		
		//RestTemplate restTemplate=new RestTemplate();
		//List<Rating> ratings=Arrays.asList(
           //       new Rating("1122",4),
      //            new Rating("1132",3)
	// );
 //     r
 //Movie movie=webClientBuilder.build().get().uri("http://localhost:8082/movies/" +rating.getMovieId()).retrieve().bodyToMono(Movie.class).block();
    	  
    	  
    //	  return new CatalogMenu(movie.getName(),"Desc",rating.getRating());
      //})
	//	.collect(Collectors.toList());
      
	}
}

		
		
	//	return Collections.singletonList(
		//		new CatalogMenu("RRR","Revolution",4)
			//	);
	
	



