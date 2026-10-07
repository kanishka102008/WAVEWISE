package com.wavewise.wavewise_backend.controller;

import com.wavewise.wavewise_backend.dto.RiskResponse;
import com.wavewise.wavewise_backend.service.RiskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/risk")
public class RiskController {

    @Autowired
    private RiskService riskService;

    @GetMapping("/{location}")
    public RiskResponse getRisk(@PathVariable String location) {
        return riskService.calculateRisk(location);
    }
}