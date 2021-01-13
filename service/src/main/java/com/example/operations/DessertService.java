package com.example.operations;

import com.example.dm.DessertCreationDTO;
import com.example.dm.DessertEditDTO;
import com.example.entity.Dessert;

/**
 * Declare an interface for the services
 */
public interface DessertService {

    Dessert getDessertRxById(String id);
    Dessert createDessertRx(DessertCreationDTO dessertCreationDTO);
    Dessert updateDessertRx(DessertEditDTO dessertEditDTO, String id);
    Dessert deleteDessertRxById(String id);

}
