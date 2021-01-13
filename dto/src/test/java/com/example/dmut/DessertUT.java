package com.example.dmut;
import com.example.dm.DessertCreationDTO;
import com.example.dm.DessertEditDTO;
import com.example.entity.Dessert;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class DessertUT {

    private static final ModelMapper modelMapper = new ModelMapper();

    @Test
    public void checkDTOMapping() {
        DessertCreationDTO creation = new DessertCreationDTO();
        creation.setName("Testing name");
        creation.setDescription("Testing description");
        creation.setIngredient("Testing ingredient");
        creation.setSteps("Testing steps");

        Dessert dessert = modelMapper.map(creation, Dessert.class);
        assertEquals(creation.getName(), dessert.getName());
        assertEquals(creation.getDescription(), dessert.getDescription());
        assertEquals(creation.getIngredient(), dessert.getIngredient());
        assertEquals(creation.getSteps(), dessert.getSteps());
        assertEquals(creation.getCreatedAt(), dessert.getCreatedAt());
        assertEquals(creation.getEditedAt(), dessert.getEditedAt());

        DessertEditDTO update = new DessertEditDTO();
        update.setName("New name");
        update.setDescription("New description");
        update.setIngredient("New ingredient");
        update.setSteps("New steps");

        modelMapper.map(update, dessert);
        assertEquals(update.getName(), dessert.getName());
        assertEquals(update.getDescription(), dessert.getDescription());
        assertEquals(update.getIngredient(), dessert.getIngredient());
        assertEquals(update.getSteps(), dessert.getSteps());
        assertEquals(creation.getCreatedAt(), dessert.getCreatedAt());
        assertEquals(update.getEditedAt(), dessert.getEditedAt());
    }
}
