package com.sam.spring.basics.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SomeExternalService {

    @Value("${external.service.url}")
    private String url;

    public String returnServiceURL(){
        return this.url;
    }
}
