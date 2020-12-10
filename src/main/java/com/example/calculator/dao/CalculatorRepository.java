package com.example.calculator.dao;

import com.example.calculator.model.Data;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface CalculatorRepository extends MongoRepository<Data, String> {
}
