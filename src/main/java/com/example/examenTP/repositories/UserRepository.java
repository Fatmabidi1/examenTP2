package com.example.examenTP.repositories;

import com.example.examenTP.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByFnameAndIname(String firstName, String lastName);
}
