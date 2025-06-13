package com.example.delta_services.controller;


import com.example.delta_services.model.CorporateAction;
import com.example.delta_services.services.CorporateActionServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Tag(name = "Corporate Action", description = "APIs for managing corporate actions")
@RestController
@RequestMapping("/api/corporate-actions")
public class CorporateActionController {

    @Autowired
   private CorporateActionServices services;

    @PostMapping
    public CorporateAction upload(@RequestBody CorporateAction action){
        return services.save(action);
    }


    @Operation(summary = "Get all corporate actions")
    @ApiResponse(responseCode = "200", description = "Successful retrieval")
    @GetMapping
    public List<CorporateAction> getAll() {
        return services.getAll();
    }


    @GetMapping("/deltas/{ticker}")
    public List<Map<String, Object>> deltas(@PathVariable String ticker) {
        return services.getDelta(ticker);
    }
    // Multiple records
    @PostMapping("/bulk")
    public List<CorporateAction> uploadBulk(@RequestBody List<CorporateAction> actions){
        return services.saveAll(actions);
    }



}
