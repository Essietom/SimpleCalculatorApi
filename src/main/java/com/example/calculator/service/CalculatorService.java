package com.example.calculator.service;

import com.example.calculator.dao.CalculatorRepository;
import com.example.calculator.model.Data;
import com.example.calculator.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CalculatorService {

    private final CalculatorRepository repository;

    @Autowired
    public CalculatorService(CalculatorRepository repository) {
        this.repository = repository;
    }

    public Result performOperation(Data data){
        int userAnswer = getUserDataAndCalculate(data);
        int resultFromDb = calculateDataFromBackEnd();
        Result myResult  = new Result();
        myResult.setResultFromUserInput(userAnswer);
        myResult.setUserInput(data);
        myResult.setLastTenDataAverage(resultFromDb);
        myResult.setFinalSolution(compareUserResultAndDbResultAndGetFinalAnswer(userAnswer, resultFromDb));
        myResult.setDateOfCalculation(LocalDateTime.now());
        return myResult;
    }

    public int getUserDataAndCalculate(Data data){
        int answer=0;
        answer = data.getA() + data.getB() - data.getC() ;
        return answer;
    }

    public int calculateDataFromBackEnd(){
        int answer = 0;
        List<Data> getLastTen = repository.findFirst10ByOrderByIdDesc();
        for(Data i:getLastTen){
           int d =  i.getA() + i.getB() + i.getC();
           answer+=d;
        }

        int ave= answer/10 ;
        return  ave;
    }

    public int compareUserResultAndDbResultAndGetFinalAnswer(int userResult, int dbResult){
        //do whatever comparison you want to do and implement your logic for getting final answer
        //e.g get final answer should be the sum of db result and user result

        return userResult + dbResult;
    }

    public List<Data> getDbData(){
        return repository.findAll();
    }
}
