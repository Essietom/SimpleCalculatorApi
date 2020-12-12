package com.example.calculator.api;

import com.example.calculator.model.Data;
import com.example.calculator.model.Result;
import com.example.calculator.service.CalculatorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CalculatorController {

    private CalculatorService service;

    public CalculatorController(CalculatorService service) {
        this.service = service;
    }

    @CrossOrigin
    @PostMapping("/perform-operation")
    public Result previewFixedDeposit(@RequestBody Data data)  {
        return service.performOperation(data);
    }

    @CrossOrigin
    @GetMapping("/get-data")
    public List<Data> displayDbData(@RequestBody Data data)  {
        return service.getDbData();
    }

}
