package com.example.controller;

import com.example.dm.DessertCreationDTO;
import com.example.dm.DessertEditDTO;
import com.example.entity.Dessert;
import com.example.operations.DessertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@RestController
public class DessertController {

    @Autowired
    private DessertService dessertService;

    @GetMapping(value = "/desserts/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Dessert> getDessert(@PathVariable(value = "id") Long id) {
        try {
            return new ResponseEntity<>(dessertService.getDessertRxById(String.valueOf(id)), HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Dessert Not Found", e
            );
        }
    }

    @GetMapping(value = "/allDesserts")
    @ResponseStatus(HttpStatus.OK)
    public List<Dessert> getDesserts() {
        return this.dessertService.getAllDessert();
    }

    @PostMapping(value = "/desserts")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Dessert> createDessert(@RequestBody DessertCreationDTO dessertCreationDTO){
        return new ResponseEntity<>(dessertService.createDessertRx(dessertCreationDTO), HttpStatus.CREATED);
    }

    @PutMapping(value = "/desserts/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Dessert> updateDessert(@RequestBody DessertEditDTO dessertEditDTO, @PathVariable(value = "id") Long id){
        return new ResponseEntity<>(dessertService.updateDessertRx(dessertEditDTO, String.valueOf(id)), HttpStatus.OK);
    }

    @DeleteMapping(value = "/desserts/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Dessert> deleteDessert(@PathVariable(value="id") Long id){
        return new ResponseEntity<>(dessertService.deleteDessertRxById(String.valueOf(id)), HttpStatus.OK);
    }

}
