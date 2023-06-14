package com.example.thirdtask;

import com.example.thirdtask.repository.UserRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepo.class)
public class ThirdTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(ThirdTaskApplication.class, args);
    }

}
