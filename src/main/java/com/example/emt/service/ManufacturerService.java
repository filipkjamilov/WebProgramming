package com.example.emt.service;

import com.example.emt.models.Manufacturer;
import com.example.emt.models.exceptions.ManufacturerNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ManufacturerService {
    void deleteAll();
    List<Manufacturer> findAll();
    Manufacturer findById(Long manufacturerId) throws ManufacturerNotFoundException;
    Manufacturer save(Manufacturer manufacturer);
}
