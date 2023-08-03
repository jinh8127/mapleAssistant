package com.jin.mapleAssistant.mapleSimulator.controller;

import com.jin.mapleAssistant.mapleSimulator.model.StarForceSimulationRequest;
import com.jin.mapleAssistant.mapleSimulator.model.StarForceSimulationResponse;
import com.jin.mapleAssistant.mapleSimulator.simulationService.SimulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/v1/Simulator")
public class SimulationController {

    private SimulationService simulationService;

    @Autowired
    public SimulationController(SimulationService simulationService) {
        this.simulationService = simulationService;
    }

    @PostMapping("/simulateStarForce")
    public ResponseEntity<StarForceSimulationResponse> simulateStarForce(@RequestBody StarForceSimulationRequest request) {

        StarForceSimulationResponse result = (StarForceSimulationResponse) simulationService.performSimulation(request);
        return ResponseEntity.ok(result);
    }

}
