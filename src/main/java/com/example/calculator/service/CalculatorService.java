package com.example.calculator.service;

import com.example.calculator.dao.CalculatorRepository;
import com.example.calculator.model.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    private final CalculatorRepository repository;

    @Autowired
    public CalculatorService(CalculatorRepository repository) {
        this.repository = repository;
    }
    public int saveAndCalculate(Data data){
        int answer=0;
        answer = data.getA() + data.getB() - data.getC() ;
        repository.save(data);
        return answer;
    }
}
