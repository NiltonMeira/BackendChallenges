package com.bosch.example.services;


import com.bosch.example.model.City;


public interface CityService {
    java.util.List<City> findByName(String city);
    java.util.List<City> findAllCities();  
} 
