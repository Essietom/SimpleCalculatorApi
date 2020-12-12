package com.example.calculator.dao;

import com.example.calculator.model.Data;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface CalculatorRepository extends MongoRepository<Data, Integer> {
    List<Data> findTopOrderByIdDesc();
}
