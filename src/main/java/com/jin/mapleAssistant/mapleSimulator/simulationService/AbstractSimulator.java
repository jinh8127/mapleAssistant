package com.jin.mapleAssistant.mapleSimulator.simulationService;

import com.jin.mapleAssistant.mapleSimulator.model.SimulationRequest;
import com.jin.mapleAssistant.mapleSimulator.model.SimulationResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public abstract class AbstractSimulator<T extends SimulationResult, R extends SimulationRequest> implements Simulator<T, R> {
    private static final Logger LOG = LoggerFactory.getLogger(StarForceSimulator.class);

    @Override
    public List<T> simulate(R request) {
        LOG.info("**** Starting simulation for {} ****", request.getClass().getCanonicalName());
        try {
            ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

            Callable<T> task = () -> simulateOnce(request);
            List<Callable<T>> tasks = IntStream.rangeClosed(1, request.getNumberOfTries()).mapToObj(o -> task).collect(Collectors.toList());
            List<Future<T>> results = executorService.invokeAll(tasks);

            // Shutdown the executor to stop accepting new tasks and wait for all tasks to complete
            executorService.shutdown();

            List<T> resultList = results.stream().map(future -> {
                try {
                    return future.get();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }).collect(Collectors.toList());

            return resultList;
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    protected abstract T simulateOnce(R request);

}
