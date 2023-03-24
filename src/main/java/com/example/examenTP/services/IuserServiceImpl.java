package com.example.examenTP.services;

import com.example.examenTP.entities.Project;
import com.example.examenTP.entities.User;
import com.example.examenTP.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class IuserServiceImpl implements IuserService {

    private UserRepository userRepository;


    @Override
    public User addUser(User user) {
        userRepository.save(user);
        return user;
    }


}

