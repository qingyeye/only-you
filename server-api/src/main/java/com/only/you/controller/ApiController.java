package com.only.you.controller;

import com.only.you.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private ApiService apiService;

    @RequestMapping("/simgle/{id}")
    public void testFeign(@PathVariable String id){

         apiService.getTest(id);
    }
}
