package com.jin.mapleAssistant.mapleSimulator.statistic;

import java.util.List;


public interface StatisticsService {
    /**
     * Returns the statistic summary (average, median, min, max, sample distribution map) of provided data set
     *
     * @param data                  list of values in Double.
     * @param numberOfIntervals     Number of intervals to create sample distribution. i.e. given range [0,1,2,3,8] with distributionRange 3,
     *                              Result will be [[0,3], [1,1], [2,1]]
     * @param startAtZero           if True, sample distribution range will start at 0 instead of Min value of data set.
     * @return StatisticSummary
     */
    public StatisticSummary getStatSummary(List<Double> data, Integer numberOfIntervals, Boolean startAtZero);

    public StatisticSummary getStatSummary(List<Double> data, Integer numberOfIntervals);

    public StatisticSummary getStatSummary(List<Double> data);

}
