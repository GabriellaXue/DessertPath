package com.example.directory;

import com.example.entity.Dessert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.xml.crypto.Data;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class DatabaseSeed implements CommandLineRunner {

    private DessertRepository dessertRepository;

    public DatabaseSeed(DessertRepository dessertRepository) {
        this.dessertRepository = dessertRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        Dessert cake = new Dessert("cake", "good", "cream and egg", "mix and bake", LocalDateTime.now(), LocalDateTime.now());
        Dessert popsicle = new Dessert("popsicle", "nice", "juice", "freeze", LocalDateTime.now(), LocalDateTime.now());

        List<Dessert> desserts = new ArrayList<>();
        desserts.add(cake);
        desserts.add(popsicle);

        this.dessertRepository.saveAll(desserts);
    }
}
