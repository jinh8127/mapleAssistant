package com.jin.mapleAssistant.mapleSimulator;

import com.jin.mapleAssistant.mapleSimulator.model.MvpType;
import com.jin.mapleAssistant.mapleSimulator.model.StarForceSimulationRequest;
import com.jin.mapleAssistant.mapleSimulator.model.StarForceSimulationResponse;
import com.jin.mapleAssistant.mapleSimulator.model.StarForceSimulationResult;
import com.jin.mapleAssistant.mapleSimulator.simulationService.StarForceSimulationService;
import com.jin.mapleAssistant.mapleSimulator.simulationService.StarForceSimulator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.math.BigInteger;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringJUnitConfig
@SpringBootTest
public class StarForceSimulatorTest {

    @Autowired
    private StarForceSimulator starForceSimulator;
    @Autowired
    private StarForceSimulationService starForceSimulationService;

    @Test
    public void testStarForceSimulationService() {
        StarForceSimulationRequest request = new StarForceSimulationRequest(100000, 200);
        request.setItemPriceInMeso(BigInteger.valueOf(0));
        request.setMvpType(MvpType.BRONZE);
        request.setTargetStarForceLevel(22);
        request.setStarCatchOn(true);
        request.setSundayDiscountEvent(false);
        request.setShiningEvent(false);
        request.setPcBangDiscounted(false);
        request.setPreventDestructionAt15(false);
        request.setPreventDestructionAt16(false);

        StarForceSimulationResponse response = starForceSimulationService.performSimulation(request);

        assertNotNull(response.getAverageDestroyCount());
        assertNotNull(response.getMinDestroyCount());
        assertNotNull(response.getMaxDestroyCount());

    }

    @Test
    public void testStarForceSimulator() {
        StarForceSimulationRequest request = new StarForceSimulationRequest(100000, 200);
        request.setItemPriceInMeso(BigInteger.valueOf(0));
        request.setMvpType(MvpType.BRONZE);
        request.setTargetStarForceLevel(22);
        request.setStarCatchOn(true);
        request.setSundayDiscountEvent(false);
        request.setShiningEvent(false);
        request.setPcBangDiscounted(false);
        request.setPreventDestructionAt15(false);
        request.setPreventDestructionAt16(false);

        List<StarForceSimulationResult> results = starForceSimulator.simulate(request);
        assertEquals(request.getNumberOfTries(), results.size());
    }
}

