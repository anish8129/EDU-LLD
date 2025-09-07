package org.example;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;

@Component
public class SlidingWindowLog {
    private final Map<String, ConcurrentLinkedDeque<Long>> logs = new ConcurrentHashMap<>();

    public synchronized boolean allowRequest(String key, int maxRequests, long windowSizeInMillis) {
        long currentTime = System.currentTimeMillis();
        long windowStart = currentTime - windowSizeInMillis;
        
        logs.putIfAbsent(key, new ConcurrentLinkedDeque<>());
        ConcurrentLinkedDeque<Long> log = logs.get(key);
        
        // Remove timestamps outside the current window
        while (!log.isEmpty() && log.peekFirst() < windowStart) {
            log.pollFirst();
        }
        
        if (log.size() < maxRequests) {
            log.addLast(currentTime);
            return true;
        }
        return false;
    }
}