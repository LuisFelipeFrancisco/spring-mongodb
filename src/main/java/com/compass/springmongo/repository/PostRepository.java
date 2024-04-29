package com.compass.springmongo.repository;

import com.compass.springmongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
public interface PostRepository extends MongoRepository<Post, String> {
}
