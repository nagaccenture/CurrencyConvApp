package com.myapp.service;

import java.util.List;

import com.myapp.persistence.City;

public interface ICityService {

    public List<City> findAll();
}