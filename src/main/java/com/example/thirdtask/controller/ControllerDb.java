package com.example.thirdtask.controller;

import com.example.thirdtask.repository.Repo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ControllerDb {

    private final Repo repo;

    public ControllerDb(Repo repo){
        this.repo =repo;
    }

    @GetMapping("/products/fetch-product")
    public List<String> getAllCustomers(@RequestParam String name){
        return repo.getProductName(name);
    }

    @GetMapping("/products")
    public String getAllCustomers(){
        return "all";
    }

    @GetMapping("/admin")
    public String admin(){
        return "Welcome admin!";
    }

    @GetMapping("/user")
    public String user(){
        return "Welcome user!";
    }
}
