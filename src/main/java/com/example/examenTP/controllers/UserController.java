package com.example.examenTP.controllers;

import com.example.examenTP.entities.User;
import com.example.examenTP.services.IuserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {
    public IuserService iuserService;
    @GetMapping("/{user}")
    public User addUser(User user){
        return iuserService.addUser(user);
    }


}
