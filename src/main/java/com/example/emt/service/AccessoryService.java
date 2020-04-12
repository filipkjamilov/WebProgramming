package com.example.emt.service;

import com.example.emt.models.Accessory;

import java.util.List;

public interface AccessoryService {

    void deleteAll();
    List<Accessory> findAll();
    Accessory save(Accessory accessory);

}
