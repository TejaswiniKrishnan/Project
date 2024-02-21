package com.example.homeproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.homeproject.model.Home;
import com.example.homeproject.repository.HomeRepo;

@Service
public class HomeService {
    @Autowired
    private final HomeRepo homeRepo;

    public HomeService(HomeRepo homeRepo) {
        this.homeRepo = homeRepo;
    }

    public Home createHome(Home home) {
        return homeRepo.save(home);
    }

    public List<Home> getAllHome() {
        return homeRepo.findAll();
    }

    public Home getHomeId(int id) {
        return homeRepo.findById(id).orElse(null);
    }

}