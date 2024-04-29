package com.compass.springmongo.repository;

import com.compass.springmongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

@RequestMapping
public interface PostRepository extends MongoRepository<Post, String> {

    List<Post> findByTitleContainingIgnoreCase(String txt);

    @Query("{'title': {$regex: ?0, $options: 'i'}}")
    List<Post> findByTitle(String txt);

    @Query("{$and: [{date: {$gte: ?1}},{date: {$lte: ?2}},{$or: [{'title': {$regex: ?0, $options: 'i'}},{'body': {$regex: ?0, $options: 'i'}},{'comments.comment': {$regex: ?0, $options: 'i'}}]}]}")
    List<Post> fullSearch(String txt, Date from, Date to);

}
