package org.example;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class FixedWindowCounter {
    private final Map<String, AtomicInteger> counters = new ConcurrentHashMap<>();
    private final Map<String, Long> windows = new ConcurrentHashMap<>();

    public synchronized boolean allowRequest(String key, int maxRequests, long windowSizeInMillis) {
        long currentTime = System.currentTimeMillis();
        long currentWindow = currentTime / windowSizeInMillis;
        
        String windowKey = key + ":" + currentWindow;
        
        if (!windows.containsKey(key) || windows.get(key) != currentWindow) {
            counters.put(key, new AtomicInteger(0));
            windows.put(key, currentWindow);
        }
        
        AtomicInteger counter = counters.get(key);
        if (counter.get() < maxRequests) {
            counter.incrementAndGet();
            return true;
        }
        return false;
    }
}