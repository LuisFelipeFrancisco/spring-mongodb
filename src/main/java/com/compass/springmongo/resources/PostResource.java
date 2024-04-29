package com.compass.springmongo.resources;

import com.compass.springmongo.domain.Post;
import com.compass.springmongo.resources.util.URL;
import com.compass.springmongo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id) {
        Post post = service.findById(id);
        return ResponseEntity.ok().body(post);
    }

    @GetMapping(value = "/titlesearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "txt", defaultValue = "") String txt) {
        txt = URL.decodeParam(txt);
        List<Post> posts = service.findByTitle(txt);
        return ResponseEntity.ok().body(posts);
    }

    @GetMapping(value = "/fullsearch")
    public ResponseEntity<List<Post>> fullSearch(
            @RequestParam(value = "txt", defaultValue = "") String txt,
            @RequestParam(value = "from", defaultValue = "") String from,
            @RequestParam(value = "to", defaultValue = "") String to) {
         txt = URL.decodeParam(txt);
         Date dateFrom = URL.decodeDate(from, new Date(Long.MIN_VALUE));
         Date dateTo = URL.decodeDate(to, new Date());
         List<Post> list = service.fullSearch(txt, dateFrom, dateTo);
         return ResponseEntity.ok().body(list);
    }

}
