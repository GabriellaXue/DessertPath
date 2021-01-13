package com.example.directory;

import com.example.entity.Dessert;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DessertRepository extends MongoRepository<Dessert, String> {

}
