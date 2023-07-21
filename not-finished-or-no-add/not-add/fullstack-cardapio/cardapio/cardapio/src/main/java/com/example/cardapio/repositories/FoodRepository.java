package com.example.cardapio.repositories;

import com.example.cardapio.entities.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long> {

}
