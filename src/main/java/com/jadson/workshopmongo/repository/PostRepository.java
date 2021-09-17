package com.jadson.workshopmongo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.jadson.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
	
	List<Post> findByTitleContainingIgnoreCase(String text);
	
	@Query("{ 'title' : { $regex: ?0, $option: 'i'}}")
	List<Post> searchByTitle(String text);
	
	@Query("{ $and: [{date: {$gte: ?1} }, {date: {$lte: ?2}}, { $or: [{ 'title' : { $regex: ?0, $option: 'i'}},{ 'body' : { $regex: ?0, $option: 'i'}},{ 'comments.text' : { $regex: ?0, $option: 'i'}}] } ] }")
	List<Post> fullSearch(String text, Date minDate, Date maxDate);

}
