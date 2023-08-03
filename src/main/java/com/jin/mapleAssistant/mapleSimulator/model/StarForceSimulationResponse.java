package com.jin.mapleAssistant.mapleSimulator.model;

import java.util.Map;

public class StarForceSimulationResponse extends SimulationResponse {

    private double averageDestroyCount;
    private int minDestroyCount;
    private int maxDestroyCount;
    private Map<Integer, Integer> destroyCountSampleDistributionMap;

    public StarForceSimulationResponse() {
        super();
    }

    public StarForceSimulationResponse(int totalAttempts, double averageMesoConsumed, double maxMesoConsumed,
                                       double minMesoConsumed, Map<Integer, Integer> mesoConsumedSampleDistributionMap) {
        super(totalAttempts, averageMesoConsumed, maxMesoConsumed, minMesoConsumed, mesoConsumedSampleDistributionMap);
    }

    public double getAverageDestroyCount() {
        return averageDestroyCount;
    }

    public int getMinDestroyCount() {
        return minDestroyCount;
    }

    public int getMaxDestroyCount() {
        return maxDestroyCount;
    }

    public Map<Integer, Integer> getDestroyCountSampleDistributionMap() {
        return destroyCountSampleDistributionMap;
    }


    public static class Builder {
        private int totalAttempts;
        private double averageMesoConsumed;
        private double maxMesoConsumed;
        private double minMesoConsumed;
        private double averageDestroyCount;
        private int minDestroyCount;
        private int maxDestroyCount;
        private Map<Integer, Integer> mesoConsumedSampleDistributionMap;
        private Map<Integer, Integer> destroyCountSampleDistributionMap;


        public Builder totalAttempts(int totalAttempts) {
            this.totalAttempts = totalAttempts;
            return this;
        }

        public Builder averageMesoConsumed(double averageMesoConsumed) {
            this.averageMesoConsumed = averageMesoConsumed;
            return this;
        }

        public Builder maxMesoConsumed(double maxMesoConsumed) {
            this.maxMesoConsumed = maxMesoConsumed;
            return this;
        }

        public Builder minMesoConsumed(double minMesoConsumed) {
            this.minMesoConsumed = minMesoConsumed;
            return this;
        }

        public Builder averageDestroyCount(double averageDestroyCount) {
            this.averageDestroyCount = averageDestroyCount;
            return this;
        }

        public Builder minDestroyCount(int minDestroryCount) {
            this.minDestroyCount = minDestroryCount;
            return this;
        }

        public Builder maxDestroyCount(int maxDestroyCount) {
            this.maxDestroyCount = maxDestroyCount;
            return this;
        }

        public Builder mesoConsumedSampleDistributionMap(Map<Integer, Integer> mesoConsumedSampleDistributionMap) {
            this.mesoConsumedSampleDistributionMap = mesoConsumedSampleDistributionMap;
            return this;
        }

        public Builder destroyCountSampleDistributionMap(Map<Integer, Integer> destroyCountSampleDistributionMap) {
            this.destroyCountSampleDistributionMap = destroyCountSampleDistributionMap;
            return this;
        }

        public StarForceSimulationResponse build() {
            StarForceSimulationResponse response = new StarForceSimulationResponse();
            response.totalAttempts = this.totalAttempts;
            response.averageMesoConsumed = this.averageMesoConsumed;
            response.maxMesoConsumed = this.maxMesoConsumed;
            response.minMesoConsumed = this.minMesoConsumed;
            response.averageDestroyCount = this.averageDestroyCount;
            response.minDestroyCount = this.minDestroyCount;
            response.maxDestroyCount = this.maxDestroyCount;
            response.mesoConsumedSampleDistributionMap = this.mesoConsumedSampleDistributionMap;
            response.destroyCountSampleDistributionMap = this.destroyCountSampleDistributionMap;
            return response;
        }
    }
}
