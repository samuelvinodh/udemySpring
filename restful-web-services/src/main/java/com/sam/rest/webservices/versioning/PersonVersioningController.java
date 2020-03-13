package com.sam.rest.webservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {

    @GetMapping("/v1/person")
    public PersonV1 getPersonV1(){
        return new PersonV1("Vinodh","Samuel");
    }

    @GetMapping("/v2/person")
    public PersonV2 getPersonV2(){
        return new PersonV2(new Name("Anu","Shimea"));
    }

    @GetMapping(value="/person/param", params="version=1")
    public PersonV1 paramPersonV1(){
        return new PersonV1("Vinodh","Samuel");
    }

    @GetMapping(value="/person/param", params="version=2")
    public PersonV2 paramPersonV2(){
        return new PersonV2(new Name("Anu","Shimea"));
    }

    @GetMapping(value="/person/header", headers="X-API-VERSION=1")
    public PersonV1 headerPersonV1(){
        return new PersonV1("Vinodh","Samuel");
    }

    @GetMapping(value="/person/header", headers="X-API-VERSION=2")
    public PersonV2 headerPersonV2(){
        return new PersonV2(new Name("Anu","Shimea"));
    }

    @GetMapping(value="/person/produces", produces="application/sam.com.app-v1+json")
    public PersonV1 producePersonV1(){
        return new PersonV1("Vinodh","Samuel");
    }

    @GetMapping(value="/person/produces", produces="application/sam.com.app-v2+json")
    public PersonV2 producePersonV2(){
        return new PersonV2(new Name("Anu","Shimea"));
    }
}
