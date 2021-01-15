package com.example.domainut;

import com.example.entity.Dessert;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DomainUt {

    @Test
    public void testGetterSetter() {

        Dessert dessert = new Dessert("name", "des", "ing", "steps", LocalDateTime.now(), LocalDateTime.now());

        assertEquals(dessert.getName(), "name");
        assertEquals(dessert.getDescription(), "des");

        dessert.setName("new name");
        dessert.setDescription("new des");
        assertEquals(dessert.getName(), "new name");
        assertEquals(dessert.getDescription(), "new des");
        
    }
}
