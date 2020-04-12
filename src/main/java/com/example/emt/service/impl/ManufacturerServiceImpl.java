package com.example.emt.service.impl;

import com.example.emt.models.Manufacturer;
import com.example.emt.models.exceptions.ManufacturerNotFoundException;
import com.example.emt.repository.ManufacturerRepository;
import com.example.emt.service.ManufacturerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {

    private final ManufacturerRepository manufacturerRepository;

    public ManufacturerServiceImpl(ManufacturerRepository manufacturerRepository) {
        this.manufacturerRepository = manufacturerRepository;
    }

    @Override
    public void deleteAll() {
        manufacturerRepository.deleteAll();
    }

    @Override
    public List<Manufacturer> findAll() {
        return manufacturerRepository.findAll();
    }

    @Override
    public Manufacturer findById(Long manufacturerId) throws ManufacturerNotFoundException {
        return manufacturerRepository.findById(manufacturerId).orElseThrow(ManufacturerNotFoundException::new);
    }

    @Override
    public Manufacturer save(Manufacturer manufacturer) {
        return manufacturerRepository.save(manufacturer);
    }
}
