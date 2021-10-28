package com.rakuten.web;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rakuten.dal.ReviewRepository;
import com.rakuten.domain.Review;

@RestController
public class ReviewController {
	
	@Autowired
	ReviewRepository repo;
	
	//  POST +JSON /reviews --> 201
	
	@PostMapping("/reviews")
	public ResponseEntity<Review> addReview(@RequestBody Review toBeAdded) {
		Review saved = repo.save(toBeAdded);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(URI.create("/reviews/"+saved.getId()));
		return new ResponseEntity<Review>(saved, headers, HttpStatus.CREATED);
	}
	
	// GET /reviews?pid=1   --> 200 
	@GetMapping("/reviews")
	public List<Review> getReviewsByProductId(@RequestParam("pid") int pid){
		return repo.findByPid(pid);
	}
}

