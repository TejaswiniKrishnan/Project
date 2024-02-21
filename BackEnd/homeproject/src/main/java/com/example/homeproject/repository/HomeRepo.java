package com.example.homeproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.homeproject.model.Home;

public interface HomeRepo extends JpaRepository<Home, Integer> {

}