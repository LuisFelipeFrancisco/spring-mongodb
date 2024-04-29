package com.compass.springmongo.services;

import com.compass.springmongo.domain.Post;
import com.compass.springmongo.repository.PostRepository;
import com.compass.springmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    public Post findById(String id) {
        Optional<Post> post = repo.findById(id);
        return post.orElseThrow(() -> new ObjectNotFoundException(id));
    }

    public List<Post> findByTitle(String txt) {
        return repo.findByTitle(txt);
    }

    public List<Post> fullSearch(String txt, Date from, Date to) {
        to = new Date(to.getTime() + 24 * 60 * 60 * 1000);
        return repo.fullSearch(txt, from, to);
    }

}
