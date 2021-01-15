package com.example.directoryUt;


import com.example.directory.DessertRepository;
import com.example.entity.Dessert;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.Test;
import org.junit.Assert;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class RepositoryUt {

    @Mock
    private DessertRepository dessertRepository;

    @InjectMocks
    Dessert dessert = new Dessert("name", "description", "ingredient", "steps", LocalDateTime.now(), LocalDateTime.now());

    @Test
    public void dessertPersistWithRepository() {

        Mockito.when(dessertRepository.save(dessert)).thenReturn(dessert);

        List<Dessert> result = dessertRepository.findAll();

        Assert.assertTrue(result.contains(dessert));
    }


}
