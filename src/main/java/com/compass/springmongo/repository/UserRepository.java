package com.compass.springmongo.repository;

import com.compass.springmongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
public interface UserRepository extends MongoRepository<User, String> {
}
