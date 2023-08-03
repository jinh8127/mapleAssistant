package com.jin.mapleAssistant.mapleSimulator.statistic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StatisticsServiceImpl implements StatisticsService {

    @Override
    public StatisticSummary getStatSummary(List<Double> data, Integer numberOfIntervals, Boolean startAtZero) {
        if (data.isEmpty()) {
            throw new IllegalArgumentException("Input list is empty.");
        }

        data.sort(null);

        // Calculate median;
        Double median;
        int size = data.size();
        if (size % 2 == 0) {
            Double middle1 = data.get(size / 2 - 1);
            Double middle2 = data.get(size / 2);
            median =  (middle1 + middle2) / 2;
        } else {
            median = data.get(size / 2).doubleValue();
        }

        Double average = data.stream().mapToDouble(Double::doubleValue).average().getAsDouble();
        Double max = data.get(data.size()-1);
        Double min = data.get(0);
        Map<Integer, Integer> sampleDistributionMap = getSampleDistributionMap(data, numberOfIntervals);

        return new StatisticSummary(average, median, max, min, sampleDistributionMap);
    }

    @Override
    public StatisticSummary getStatSummary(List<Double> data, Integer distributionRange) {
        return getStatSummary(data, distributionRange, false);
    }

    @Override
    public StatisticSummary getStatSummary(List<Double> data) {
        return getStatSummary(data, 30, false);
    }

    /**
     * Creates sample distribution map from sorted list of data set with provided number of intervals.
     *
     * @param data  List of dataset. must be sorted.
     * @param numberOfIntervals   Number of intervals to create sample distribution map
     * @return SampleDistributionMap
     */
    private Map<Integer, Integer> getSampleDistributionMap(List<Double> data, Integer numberOfIntervals) {
        Map<Integer, Integer> distribution = new HashMap<>();
        Double max = data.get(data.size()-1);
        Double divisor = max/(numberOfIntervals-1);

        data.parallelStream()
            .forEach(number -> {
                int index = (int) (number/divisor);
                synchronized (distribution) {
                    distribution.put(index, distribution.getOrDefault(index, 0) + 1);
                }
            });

        return distribution;
    }


}
