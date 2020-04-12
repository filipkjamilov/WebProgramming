package com.example.emt.service.impl;

import com.example.emt.models.Accessory;
import com.example.emt.repository.AccessoryRepository;
import com.example.emt.service.AccessoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccessoryServiceImpl implements AccessoryService {

    private final AccessoryRepository accessoryRepository;

    public AccessoryServiceImpl(AccessoryRepository accessoryRepository) {
        this.accessoryRepository = accessoryRepository;
    }

    @Override
    public void deleteAll() {
        accessoryRepository.deleteAll();
    }

    @Override
    public List<Accessory> findAll() {
        return accessoryRepository.findAll();
    }



    @Override
    public Accessory save(Accessory accessory) {
        return accessoryRepository.save(accessory);
    }
}
