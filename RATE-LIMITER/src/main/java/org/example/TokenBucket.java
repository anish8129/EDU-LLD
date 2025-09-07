package org.example;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class TokenBucket {
    private final Map<String, AtomicInteger> tokens = new ConcurrentHashMap<>();
    private final Map<String, Integer> capacities = new ConcurrentHashMap<>();
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public TokenBucket() {
        // Refill tokens every second
        scheduler.scheduleAtFixedRate(this::refillTokens, 1, 1, TimeUnit.SECONDS);
    }

    public synchronized boolean allowRequest(String key, int capacity, int refillRate) {
        capacities.putIfAbsent(key, capacity);
        tokens.putIfAbsent(key, new AtomicInteger(capacity));
        
        AtomicInteger tokenCount = tokens.get(key);
        if (tokenCount.get() > 0) {
            tokenCount.decrementAndGet();
            return true;
        }
        return false;
    }

    private void refillTokens() {
        for (String key : capacities.keySet()) {
            AtomicInteger tokenCount = tokens.get(key);
            int capacity = capacities.get(key);
            tokenCount.set(Math.min(tokenCount.get() + 1, capacity));
        }
    }
}