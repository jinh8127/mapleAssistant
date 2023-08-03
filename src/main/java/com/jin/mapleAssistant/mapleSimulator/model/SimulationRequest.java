package com.jin.mapleAssistant.mapleSimulator.model;

public abstract class SimulationRequest {
    protected final int numberOfTries;
    protected final int itemLevel;

    public SimulationRequest(int numberOfTries, int itemLevel) {
        this.numberOfTries = numberOfTries;
        this.itemLevel = itemLevel;
    }

    public int getNumberOfTries() {
        return numberOfTries;
    }

    public int getItemLevel() {
        return itemLevel;
    }
}
