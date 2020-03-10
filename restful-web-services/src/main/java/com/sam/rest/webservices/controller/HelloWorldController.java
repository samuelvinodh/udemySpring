package com.sam.rest.webservices.controller;

import com.sam.rest.webservices.model.HelloWorldBean;
import org.springframework.web.bind.annotation.*;

//Controller
@RestController
public class HelloWorldController {
    //GET
    //URI - /hello-world
    //method -> "Hello World"
    //@RequestMapping(method= RequestMethod.GET, path="/hello-world")
    @GetMapping(path="/hello-world")
    public String helloWorld(){
        return "Hello World";
    }

    //URI - /hello-world-bean
    @GetMapping(path="/hello-world-bean")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("Hello World");
    }

    //URI - /hello-world/path-variable/{name}
    @GetMapping(path="/hello-world/path-variable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name){
        return new HelloWorldBean(String.format("Hello world, %s",name));
    }
}
