package com.devsuperior.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.demo.entities.City;

public interface CityRepository extends JpaRepository<City, Long> {
    

    @Query(value = "SELECT obj FROM City obj ORDER BY obj.name")
    public List<City> findAll();
}
