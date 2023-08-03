package com.jin.mapleAssistant.mapleSimulator.simulationService;

import com.jin.mapleAssistant.mapleSimulator.model.SimulationRequest;
import com.jin.mapleAssistant.mapleSimulator.model.SimulationResponse;


public interface SimulationService<T extends SimulationRequest, R extends SimulationResponse> {

   public R performSimulation(T request);
}
