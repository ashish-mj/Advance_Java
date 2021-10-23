package com.rakuten.dal;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.rakuten.domain.Review;

public interface ReviewRepository extends CrudRepository<Review, Integer>{
	
	public List<Review> findByPid(int pid);

}