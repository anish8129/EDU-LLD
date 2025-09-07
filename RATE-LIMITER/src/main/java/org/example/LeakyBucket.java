package org.example;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class LeakyBucket {
    private final Map<String, AtomicInteger> buckets = new ConcurrentHashMap<>();
    private final Map<String, Integer> capacities = new ConcurrentHashMap<>();
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public LeakyBucket() {
        // Process requests at fixed rate
        scheduler.scheduleAtFixedRate(this::processRequests, 1, 1, TimeUnit.SECONDS);
    }

    public synchronized boolean allowRequest(String key, int capacity, int leakRate) {
        capacities.putIfAbsent(key, capacity);
        buckets.putIfAbsent(key, new AtomicInteger(0));
        
        AtomicInteger bucketSize = buckets.get(key);
        if (bucketSize.get() < capacity) {
            bucketSize.incrementAndGet();
            return true;
        }
        return false;
    }

    private void processRequests() {
        for (String key : capacities.keySet()) {
            AtomicInteger bucketSize = buckets.get(key);
            int leakRate = 1; // Leak 1 request per second
            bucketSize.set(Math.max(bucketSize.get() - leakRate, 0));
        }
    }
}