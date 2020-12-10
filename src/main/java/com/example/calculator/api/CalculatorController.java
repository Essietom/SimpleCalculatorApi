package com.example.calculator.api;

import com.example.calculator.model.Data;
import com.example.calculator.service.CalculatorService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CalculatorController {

    private CalculatorService service;

    public CalculatorController(CalculatorService service) {
        this.service = service;
    }

    @PostMapping("/collect-data")
    public int previewFixedDeposit(@RequestBody Data data)  {
        return service.saveAndCalculate(data);
    }

}
