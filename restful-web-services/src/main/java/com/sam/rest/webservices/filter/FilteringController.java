package com.sam.rest.webservices.filter;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    @GetMapping("/filtering")
    public SomeBean retrieveSomeBean(){
        return new SomeBean("value1","value2","value3");
    }

    @GetMapping("/filtering-list")
    public List<SomeBean> retrieveSomeBeans(){
        return Arrays.asList(new SomeBean("value1","value2","value3"),
                new SomeBean("value12","value22","value32"));
    }

    @GetMapping("/filtering-dynamic")
    public MappingJacksonValue retrieveDynamic(){
        SomeBeanDynamic someBeanDynamic = new SomeBeanDynamic(
                "value1","value2","value3","value4");
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter
                .filterOutAllExcept("field1","field2","field4");
        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
        MappingJacksonValue mapping = new MappingJacksonValue(someBeanDynamic);
        mapping.setFilters(filters);
        return mapping;
    }

    @GetMapping("/filtering-dynamic-list")
    public MappingJacksonValue retrieveDynamics(){
        List<SomeBeanDynamic> list = Arrays.asList(new SomeBeanDynamic("value1","value2","value3","value4"),
                new SomeBeanDynamic("value12","value22","value32","value42"));
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field2","field4");
        FilterProvider filterProvider = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(list);
        mappingJacksonValue.setFilters(filterProvider);
        return mappingJacksonValue;
    }
}
