package com.jin.mapleAssistant.mapleSimulator.model;

import java.util.Map;

public abstract class SimulationResponse {
    protected int totalAttempts;
    protected double averageMesoConsumed;
    protected double maxMesoConsumed;
    protected double minMesoConsumed;
    protected Map<Integer, Integer> mesoConsumedSampleDistributionMap;

    public SimulationResponse(int totalAttempts, double averageMesoConsumed, double maxMesoConsumed, double minMesoConsumed, Map<Integer, Integer>  mesoConsumedSampleDistributionMap) {
        this.totalAttempts = totalAttempts;
        this.averageMesoConsumed = averageMesoConsumed;
        this.maxMesoConsumed = maxMesoConsumed;
        this.minMesoConsumed = minMesoConsumed;
        this.mesoConsumedSampleDistributionMap = mesoConsumedSampleDistributionMap;
    }

    public SimulationResponse() {
    }
}
