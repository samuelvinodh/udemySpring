package com.sam.rest.webservices.controller;

import com.sam.rest.webservices.dao.UserDAO;
import com.sam.rest.webservices.exception.UserNotFoundException;
import com.sam.rest.webservices.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
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
    public EntityModel<User> retrieveUser(@PathVariable int id){
        User user = userDAO.findOne(id);
        if(user==null){
            throw new UserNotFoundException("id-"+id);
        }
        //HATEOAS (sending additional supporting info)
        EntityModel<User> userEntityModel = new EntityModel<>(user);
        WebMvcLinkBuilder linkBuilder = WebMvcLinkBuilder.linkTo
                (WebMvcLinkBuilder.methodOn(this.getClass()).retrieveAllUsers());
        userEntityModel.add(linkBuilder.withRel("all-users"));
        return userEntityModel;
    }

    //input -> details of the user
    //output <- CREATED code & return created URI
    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user){
        User savedUser = userDAO.save(user);
        //CREATED
        //URI of resource created
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public User deleteUser(@PathVariable int id){
        User user = userDAO.deleteById(id);
        if(user==null){
            throw new UserNotFoundException("id-"+id);
        }
        return user;
    }
}
