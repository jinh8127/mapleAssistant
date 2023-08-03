package com.jin.mapleAssistant.mapleSimulator.simulationService;

import com.jin.mapleAssistant.mapleSimulator.model.SimulationRequest;
import com.jin.mapleAssistant.mapleSimulator.model.SimulationResult;

import java.util.List;


public interface Simulator<T extends SimulationResult, R extends SimulationRequest> {
    List<T> simulate(R request);
}
