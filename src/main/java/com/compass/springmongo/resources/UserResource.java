package com.compass.springmongo.resources;

import com.compass.springmongo.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    // @RequestMapping(method = RequestMethod.GET)
    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        User felipe = new User("1", "Felipe Ferreira", "felipe@email.com");
        User luis = new User("2", "Luis Francisco", "luis@email.com");

        List<User> list = new ArrayList<User>();

        list.addAll(Arrays.asList(felipe,luis));

        return ResponseEntity.ok().body(list);
    }

}
