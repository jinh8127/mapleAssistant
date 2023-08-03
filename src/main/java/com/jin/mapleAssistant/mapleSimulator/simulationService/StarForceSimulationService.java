package com.jin.mapleAssistant.mapleSimulator.simulationService;

import com.jin.mapleAssistant.mapleSimulator.statistic.StatisticSummary;
import com.jin.mapleAssistant.mapleSimulator.statistic.StatisticsService;
import com.jin.mapleAssistant.mapleSimulator.model.*;

import java.util.List;

import java.util.stream.Collectors;

public class StarForceSimulationService implements SimulationService<StarForceSimulationRequest, StarForceSimulationResponse> {

    private final StarForceSimulator simulator;
    private final StatisticsService statisticsService;

    public StarForceSimulationService(StarForceSimulator simulator, StatisticsService statisticsService) {
        this.simulator = simulator;
        this.statisticsService = statisticsService;
    }

    @Override
    public StarForceSimulationResponse performSimulation(StarForceSimulationRequest request) {
        List<StarForceSimulationResult> result = simulator.simulate(request);
        return createResponse(result);
    }

    private StarForceSimulationResponse createResponse(List<StarForceSimulationResult> results) {

        List<Double> mesoList = results.parallelStream()
                .map(result -> result.getTotalMesoConsumed().doubleValue())
                .collect(Collectors.toList());

        StatisticSummary mesoCostStatSummary = statisticsService.getStatSummary(mesoList, 40, true);


        List<Double> destroyCountList = results.parallelStream()
                .map(result -> result.getTotalMesoConsumed().doubleValue())
                .collect(Collectors.toList());

        StatisticSummary destroyCountStatSummary= statisticsService.getStatSummary(destroyCountList, 40, true);


        StarForceSimulationResponse response = new StarForceSimulationResponse.Builder()
                .totalAttempts(results.size())
                .averageMesoConsumed(mesoCostStatSummary.getAverage())
                .maxMesoConsumed(mesoCostStatSummary.getMax())
                .minMesoConsumed(mesoCostStatSummary.getMin())
                .mesoConsumedSampleDistributionMap(mesoCostStatSummary.getDistribution())
                .averageDestroyCount(destroyCountStatSummary.getAverage())
                .maxDestroyCount(Integer.valueOf(destroyCountStatSummary.getMax().intValue()))
                .minDestroyCount(Integer.valueOf(destroyCountStatSummary.getMin().intValue()))
                .destroyCountSampleDistributionMap(destroyCountStatSummary.getDistribution())
                .build();

        return response;
    }
}
