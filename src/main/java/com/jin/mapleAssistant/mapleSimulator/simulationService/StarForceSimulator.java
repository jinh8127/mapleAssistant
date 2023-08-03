package com.jin.mapleAssistant.mapleSimulator.simulationService;
import com.jin.mapleAssistant.mapleSimulator.model.StarForceSimulationRequest;
import com.jin.mapleAssistant.mapleSimulator.model.StarForceSimulationResult;
import org.apache.commons.math3.util.Precision;

import java.math.BigDecimal;
import java.math.BigInteger;

import java.util.Map;
import java.util.Random;

public class StarForceSimulator extends AbstractSimulator<StarForceSimulationResult, StarForceSimulationRequest> {

    private static final double PC_BANG_DISCOUNT_AMOUNT = 0.05;
    private static final double SUNDAY_EVENT_DISCOUNT_AMOUNT = 0.30;

    private final Map<Integer, Double> starForceSuccessChanceMap;
    private final Map<Integer, Double> starForceDestroyChanceMap;
    private final Map<String, Double> starForceMvpDiscountMap;

    public StarForceSimulator(Map<Integer, Double> starForceSuccessChanceMap, Map<Integer, Double> starForceDestroyChanceMap, Map<String, Double> starForceMvpDiscountMap) {
        this.starForceSuccessChanceMap = starForceSuccessChanceMap;
        this.starForceDestroyChanceMap = starForceDestroyChanceMap;
        this.starForceMvpDiscountMap = starForceMvpDiscountMap;
    }

    @Override
    protected StarForceSimulationResult simulateOnce(StarForceSimulationRequest request) {
        Integer currentStarLevel = 0;
        Integer destroyCounter = 0;
        Integer chanceTimeCounter = 0;
        BigInteger totalMesoSpent = BigInteger.ZERO;

        while (currentStarLevel < request.getTargetStarForceLevel()) {

            double successChance = starForceSuccessChanceMap.getOrDefault(currentStarLevel, 0.0);
            double destroyRate = starForceDestroyChanceMap.getOrDefault(currentStarLevel, 0.0);

            if (successChance == 0.0) {
                throw new RuntimeException("successChance should not be 0");
            }

            if (request.isStarCatchOn()) {
                double NewSuccessChance = successChance * 1.05;
                destroyRate = destroyRate * ((100-NewSuccessChance)/(100-successChance));
                successChance = NewSuccessChance;
            }

            // get random number n where, 0 < n <= 100
            double randomValue = 100 - new Random().nextDouble(0,100);

            BigInteger mesoCost = calculateMesoCost(currentStarLevel, request);
            totalMesoSpent = totalMesoSpent.add(mesoCost);

            if (chanceTimeCounter == 2) {
                currentStarLevel++;
                chanceTimeCounter = 0;
                continue;
            }

            //destroyed
            if (randomValue <= destroyRate && !isDestructionPrevented(currentStarLevel, request)) {
                destroyCounter++;
                currentStarLevel = 12;
                chanceTimeCounter = 0;
                totalMesoSpent = totalMesoSpent.add(request.getItemPriceInMeso());

            //success
            } else if (randomValue <= successChance + destroyRate) {
                currentStarLevel++;
                chanceTimeCounter = 0;

            //
            } else {
                if (currentStarLevel > 15 && currentStarLevel != 20) {
                    currentStarLevel--;
                    chanceTimeCounter++;
                }
            }
        }

        StarForceSimulationResult result =  new StarForceSimulationResult(totalMesoSpent,destroyCounter);
        return result;
    }

    private boolean isDestructionPrevented(Integer currentStarLevel, StarForceSimulationRequest request) {
        if (currentStarLevel < 15) {
            return true;
        } else if (currentStarLevel > 16) {
            return false;
        } else if (currentStarLevel == 15) {
            return request.isPreventDestructionAt15();
        } else if (currentStarLevel == 16) {
            return request.isPreventDestructionAt16();
        }
        return false;
    }

    private BigInteger calculateMesoCost(int currentStarLevel, StarForceSimulationRequest request) {
        int itemLevel = request.getItemLevel();
        int baseCost = 0;

        if (currentStarLevel < 10) {
            baseCost = (int) (1000 + Math.pow(itemLevel, 3) * (currentStarLevel + 1)/25);
        } else if (currentStarLevel == 10 ) {
            baseCost = (int) (1000 + Math.pow(itemLevel,3) * Math.pow((currentStarLevel + 1), 2.7)/400);
        } else if (currentStarLevel == 11 ) {
            baseCost = (int) (1000 + Math.pow(itemLevel, 3) * Math.pow((currentStarLevel + 1), 2.7)/220);
        } else if (currentStarLevel == 12 ) {
            baseCost = (int) (1000 + Math.pow(itemLevel, 3) * Math.pow((currentStarLevel + 1), 2.7)/150);
        } else if (currentStarLevel == 13 ) {
            baseCost = (int) (1000 + Math.pow(itemLevel, 3) * Math.pow((currentStarLevel + 1), 2.7)/110);
        } else if (currentStarLevel == 14 ) {
            baseCost = (int) (1000 + Math.pow(itemLevel, 3) * Math.pow((currentStarLevel + 1), 2.7)/75);
        } else {
            baseCost = (int) (1000 + Math.pow(itemLevel,3) * Math.pow((currentStarLevel + 1), 2.7)/200);
        }

        baseCost = (int) Precision.round(baseCost, -2);

        double pcBangDiscount = request.isPcBangDiscounted() ? PC_BANG_DISCOUNT_AMOUNT : 0.0;
        double sundayEventDiscount = (request.isShiningEvent() || request.isSundayDiscountEvent()) ? SUNDAY_EVENT_DISCOUNT_AMOUNT : 0.0;
        double mvpDiscount = starForceMvpDiscountMap.getOrDefault(request.getMvpType(), 0.0);

        BigDecimal costAfterDiscount = BigDecimal.valueOf(Math.ceil(baseCost * (1 - (mvpDiscount + pcBangDiscount)) * (1-sundayEventDiscount)));

        return costAfterDiscount.toBigInteger();
    }
}
