package com.sam.rest.webservices.controller;

import com.sam.rest.webservices.dao.UserDAO;
import com.sam.rest.webservices.exception.UserNotFoundException;
import com.sam.rest.webservices.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserResource {

    @Autowired
    UserDAO userDAO;

    @GetMapping(path="/users")
    public List<User> retrieveAllUsers(){
        return userDAO.findAll();
    }

    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable int id){
        User user = userDAO.findOne(id);
        if(user==null){
            throw new UserNotFoundException("id-"+id);
        }
        return user;
    }

    //input -> details of the user
    //output <- CREATED code & return created URI
    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@RequestBody User user){
        User savedUser = userDAO.save(user);
        //CREATED
        //URI of resource created
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
}
