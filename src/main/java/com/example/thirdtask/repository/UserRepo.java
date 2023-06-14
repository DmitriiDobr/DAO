package com.example.thirdtask.repository;


import com.example.thirdtask.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<Users,Integer> {


    Optional<Users> findByUserName(String userName);
}
