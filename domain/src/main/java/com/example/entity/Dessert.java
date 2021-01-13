package com.example.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString

@Document(collection = "Dessert")
public class Dessert {
    @Id
    private String id;

    private String name;
    private String description;
    private String ingredient ;
    private String steps;
    private LocalDateTime createdAt;
    private LocalDateTime editedAt;
//    private boolean published;

    protected Dessert(){}

    public Dessert(String name, String description, String ingredient, String steps, LocalDateTime createdAt, LocalDateTime editedAt) {
        this.name = name;
        this.description = description;
        this.ingredient = ingredient;
        this.steps = steps;
        this.createdAt = createdAt;
        this.editedAt = editedAt;
    }
}
