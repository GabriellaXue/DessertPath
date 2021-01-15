package com.example.operations;

import com.example.directory.DessertRepository;
import com.example.dm.DessertCreationDTO;
import com.example.dm.DessertEditDTO;
import com.example.entity.Dessert;
import com.mongodb.MongoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implement CRUD operations defined in the DessertService
 */
@Service
public class DessertServiceImpl implements DessertService{

        @Autowired
        private DessertRepository dessertRepository;

        /*
         * Read an instance
         */
        @Override
        public Dessert getDessertRxById(String id) {
                if (dessertRepository.findById(id).isPresent()) {
                        return dessertRepository.findById(id).get();
                } else {
                        throw new MongoException("Record Not Found");
                }
        }

        @Override
        public List<Dessert> getAllDessert() {
                if (dessertRepository.findAll().size() != 0) {
                        return dessertRepository.findAll();
                } else {
                        throw new MongoException("Empty");
                }
        }

        /*
         * Create a new instance
         */
        @Override
        public Dessert createDessertRx(DessertCreationDTO dessertCreationDTO) {
                Dessert dessert = new Dessert(dessertCreationDTO.getName(),
                                                dessertCreationDTO.getDescription(),
                                                        dessertCreationDTO.getIngredient(),
                                                                dessertCreationDTO.getSteps(),
                                                                        dessertCreationDTO.getCreatedAt(),
                                                                                dessertCreationDTO.getEditedAt());
                return dessertRepository.save(dessert);
        }

        /*
         * Update an instance
         */
        @Override
        public Dessert updateDessertRx(DessertEditDTO dessertEditDTO, String id) {
                if (dessertRepository.findById(id).isPresent()) {
                        Dessert existingDessert = dessertRepository.findById(id).get();
                        existingDessert.setName(dessertEditDTO.getName());
                        existingDessert.setDescription(dessertEditDTO.getDescription());
                        existingDessert.setIngredient(dessertEditDTO.getIngredient());
                        existingDessert.setSteps(dessertEditDTO.getSteps());
                        existingDessert.setEditedAt(dessertEditDTO.getEditedAt());
                        return dessertRepository.save(existingDessert);
                } else {
                        throw new MongoException("Record Not Found");
                }
        }

        /*
         * Delete an instance
         */
        @Override
        public Dessert deleteDessertRxById(String id){
                if (dessertRepository.findById(id).isPresent()) {
                        Dessert dessert = dessertRepository.findById(id).get();
                        dessertRepository.delete(dessert);
                        return dessert;
                } else {
                        throw new MongoException("Record Not Found");
                }
        }



}
