package com.only.you.controller;

import com.only.you.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MoviceController {

    @GetMapping("/simple/{id}")
    public User findById(@PathVariable Long id) {
        User user = new User();
        user.setUserName("zhangsan");
        return user;
    }
}
