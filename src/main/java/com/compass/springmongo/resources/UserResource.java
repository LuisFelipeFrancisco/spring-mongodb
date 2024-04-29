package com.compass.springmongo.resources;

import com.compass.springmongo.domain.User;
import com.compass.springmongo.dot.UserDTO;
import com.compass.springmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService service;

    // @RequestMapping(method = RequestMethod.GET)
    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll(){
        List<User> users = service.findAll();
        List<UserDTO> usersDTO = users.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok(usersDTO);
    }

}
