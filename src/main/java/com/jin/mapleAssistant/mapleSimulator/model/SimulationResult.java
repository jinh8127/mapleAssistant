package com.jin.mapleAssistant.mapleSimulator.model;

import java.math.BigInteger;

public abstract class SimulationResult {
    BigInteger totalMesoConsumed;

    public BigInteger getTotalMesoConsumed() {
        return totalMesoConsumed;
    }

    public void setTotalMesoConsumed(BigInteger totalMesoConsumed) {
        this.totalMesoConsumed = totalMesoConsumed;
    }
}
