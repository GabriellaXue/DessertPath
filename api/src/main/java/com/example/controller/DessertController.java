package com.example.controller;

import com.example.directory.DessertRepository;
import com.example.entity.Dessert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DessertController {

    @Autowired
    private DessertRepository dessertRepository;

    @GetMapping("/desserts")
    public List<Dessert> getDesserts() {
        List<Dessert> desserts = this.dessertRepository.findAll();
        return desserts;
    }

    @PostMapping("/addDessert")
    public String saveDessert(@RequestBody Dessert dessert) {
        dessertRepository.save(dessert);
        return "Added dessert with id: " + dessert.getId();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteDessert(@PathVariable String id) {
        dessertRepository.deleteById(id);
        return "Delete dessert with id: " + id;
    }

}
