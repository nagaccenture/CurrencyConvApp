package com.myapp.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myapp.persistence.CityRepository;
import com.myapp.persistence.City;
import com.myapp.service.ICityService;

@Service
public class CityService<City> implements ICityService {

    @Autowired
    private CityRepository repository;

    @Override
    public List<com.myapp.persistence.City> findAll() {

        List<City> cities = (List<City>) repository.findAll();
        
        return (List<com.myapp.persistence.City>) cities;
    }
}