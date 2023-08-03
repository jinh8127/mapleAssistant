package com.jin.mapleAssistant.mapleSimulator.model;


import java.math.BigInteger;

public class StarForceSimulationResult extends SimulationResult {

    private int destroyCount;

    public int getDestroyCount() {
        return destroyCount;
    }

    public void setDestroyCount(int destroyCount) {
        this.destroyCount = destroyCount;
    }

    public StarForceSimulationResult(BigInteger totalMesoConsumed, int destroyCount) {
        this.totalMesoConsumed = totalMesoConsumed;
        this.destroyCount = destroyCount;
    }
}
