package com.example.dm;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Getter
@Setter
public class DessertEditDTO {

    @Id
    private String id;

    private String name;
    private String description;
    private String ingredient;
    private String steps;

    @JsonIgnore
    private final LocalDateTime editedAt = LocalDateTime.now();

}
