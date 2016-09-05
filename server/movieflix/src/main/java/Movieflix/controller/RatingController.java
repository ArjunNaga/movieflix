package Movieflix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import Movieflix.entity.Movie;
import Movieflix.entity.Rating;
import Movieflix.service.RatingService;


@RestController
@RequestMapping(value = "ratings", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class RatingController {

	@Autowired
	private RatingService ratingService; 
	
	@RequestMapping(method = RequestMethod.GET)
	public List <Rating> findAll() {
		return ratingService.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	public  Rating findOne(@PathVariable("id") String ratingId) {
		return ratingService.findOne(ratingId);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public  Rating create(@RequestBody Rating rating) {
		return ratingService.create(rating);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public  Rating update(@PathVariable("id") String ratingId, @RequestBody Rating rating) {
		return ratingService.update(ratingId,rating);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	public void delete(@PathVariable("id") String ratingId) {
		ratingService.remove(ratingId);
	}
}