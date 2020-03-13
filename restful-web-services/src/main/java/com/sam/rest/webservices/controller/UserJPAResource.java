package com.sam.rest.webservices.controller;

import com.sam.rest.webservices.dao.PostRepository;
import com.sam.rest.webservices.dao.UserDAO;
import com.sam.rest.webservices.dao.UserRepository;
import com.sam.rest.webservices.exception.UserNotFoundException;
import com.sam.rest.webservices.model.Post;
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
import java.util.Optional;

@RestController
@RequestMapping("/jpa")
public class UserJPAResource {

    //@Autowired
    //private UserDAO userDAO;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @GetMapping(path="/users")
    public List<User> retrieveAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/users/{id}")
    public EntityModel<User> retrieveUser(@PathVariable int id){
        Optional<User> user = userRepository.findById(id);
        if(!user.isPresent()){
            throw new UserNotFoundException("id-"+id);
        }
        //HATEOAS (sending additional supporting info)
        EntityModel<User> userEntityModel = new EntityModel<>(user.get());
        WebMvcLinkBuilder linkBuilder = WebMvcLinkBuilder.linkTo
                (WebMvcLinkBuilder.methodOn(this.getClass()).retrieveAllUsers());
        userEntityModel.add(linkBuilder.withRel("all-users"));
        return userEntityModel;
    }

    //input -> details of the user
    //output <- CREATED code & return created URI
    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user){
        User savedUser = userRepository.save(user);
        //CREATED
        //URI of resource created
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id){
        userRepository.deleteById(id);
    }

    @GetMapping(path="/users/{id}/posts")
    public List<Post> retrieveAllUserPosts(@PathVariable Integer id){
        Optional<User> userOptional = userRepository.findById(id);
        if(!userOptional.isPresent()){
            throw new UserNotFoundException("id-"+id);
        }
        return userOptional.get().getPosts();
    }

    @PostMapping("/users/{id}/posts")
    public ResponseEntity<Object> createPosts(@PathVariable Integer id, @RequestBody Post post){
        Optional<User> userOptional = userRepository.findById(id);
        if(!userOptional.isPresent()){
            throw new UserNotFoundException("id-"+id);
        }
        User user = userOptional.get();
        post.setUser(user);
        postRepository.save(post);
        //CREATED
        //URI of resource created
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(post.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
}
