package com.example.directoryUt;

import com.example.developmenttask.DevelopmentTaskApplication;
import com.example.directory.DessertRepository;
import com.example.entity.Dessert;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes= {DevelopmentTaskApplication.class})
public class RepositoryUt {

    @Mock
    private DessertRepository dessertRepository;

    @Test
    public void dessertPersistWithRepository() {

        Dessert dessert = new Dessert("name", "description", "ingredient", "steps", LocalDateTime.now(), LocalDateTime.now());
        dessertRepository.save(dessert);

        List<Dessert> result = dessertRepository.findAll();

        assertEquals(result.size(), 1);
        assertEquals(result.contains(dessert), true);
    }


}
