package com.example.calculator.dao;

import com.example.calculator.model.Data;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;


public interface CalculatorRepository extends MongoRepository<Data, Integer> {
    @Query
    List<Data> findFirst10ByOrderByIdDesc();
}
