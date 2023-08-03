package com.jin.mapleAssistant.mapleSimulator.statistic;

import java.util.Map;

public class StatisticSummary {
    private Double average;
    private Double median;
    private Double max;
    private Double min;
    private Map<Integer, Integer> distribution;

    public StatisticSummary(Double average, Double median, Double max, Double min, Map<Integer, Integer> distribution) {
        this.average = average;
        this.median = median;
        this.max = max;
        this.min = min;
        this.distribution = distribution;
    }

    public Double getAverage() {
        return average;
    }

    public void setAverage(Double average) {
        this.average = average;
    }

    public Double getMedian() {
        return median;
    }

    public void setMedian(Double median) {
        this.median = median;
    }

    public Double getMax() {
        return max;
    }

    public void setMax(Double max) {
        this.max = max;
    }

    public Double getMin() {
        return min;
    }

    public void setMin(Double min) {
        this.min = min;
    }

    public Map<Integer, Integer> getDistribution() {
        return distribution;
    }

    public void setDistribution(Map<Integer, Integer> distribution) {
        this.distribution = distribution;
    }

    @Override
    public String toString() {
        return "StatisticSummary{" +
                "average=" + average +
                ", median=" + median +
                ", max=" + max +
                ", min=" + min +
                ", distribution=" + distribution +
                '}';
    }
}
