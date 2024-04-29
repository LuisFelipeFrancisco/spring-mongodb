package com.compass.springmongo.services;

import com.compass.springmongo.domain.Post;
import com.compass.springmongo.repository.PostRepository;
import com.compass.springmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    public Post findById(String id) {
        Optional<Post> post = repo.findById(id);
        return post.orElseThrow(() -> new ObjectNotFoundException(id));
    }

}
