package io.drucare.ratingdataservice.Resource;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.drucare.ratingdataservice.Model.Rating;
import io.drucare.ratingdataservice.Model.UserRating;

@RestController
public class RatingResource {
	
	@RequestMapping("/ratingsdata/{movieId}")
	public Rating getRating(@PathVariable("movieId") String movieId) {
		return new Rating(movieId,4);
	}
		@RequestMapping("/users/{userId}")
		public UserRating getuserRating(@PathVariable("userId") String userId) {
		List<Rating> ratings=Arrays.asList(
	                  new Rating("1122",4),
	                  new Rating("1132",3)
		);
		 UserRating userRating=new UserRating();
		 userRating.setUserRating(ratings);
return userRating;		

		}
	}

