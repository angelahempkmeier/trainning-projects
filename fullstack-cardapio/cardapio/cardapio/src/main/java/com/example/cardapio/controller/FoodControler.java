package com.example.cardapio.controller;

import com.example.cardapio.entities.FoodResponseDTO;
import com.example.cardapio.repositories.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("food")
public class FoodControler {

    @Autowired
    FoodRepository repository;

    @GetMapping
    public List<FoodResponseDTO> getAll(){
        List<FoodResponseDTO> foodList = repository.findAll().stream().map(FoodResponseDTO::new).toList();
        return foodList;
    }

    @PostMapping
    public void saveFood(@RequestBody ){

    }
}
