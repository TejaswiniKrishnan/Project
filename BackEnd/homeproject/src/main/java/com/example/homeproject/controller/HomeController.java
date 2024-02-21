package com.example.homeproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.homeproject.model.Home;
import com.example.homeproject.service.HomeService;

@RestController
@RequestMapping("/api")
public class HomeController {
    @Autowired
    private final HomeService homeService;

    public HomeController(HomeService homeService) {
        this.homeService = homeService;
    }

    @PostMapping("/homes")
    // insert the data
    public ResponseEntity<Home> createHome(@RequestBody Home home) {
        Home creatHome = homeService.createHome(home);
        return new ResponseEntity<>(creatHome, HttpStatus.CREATED);
    }

    @GetMapping("/home")
    public ResponseEntity<List<Home>> getAllHome() {
        List<Home> homes = homeService.getAllHome();
        return new ResponseEntity<>(homes, HttpStatus.OK);
    }

    @GetMapping("/home/{id}")
    public ResponseEntity<Home> getById(@PathVariable int id) {
        Home home = homeService.getHomeId(id);
        if (home != null) {
            return new ResponseEntity<>(home, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
