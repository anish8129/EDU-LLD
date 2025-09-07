package org.example;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class SlidingWindowCounter {
    private final Map<String, SlidingWindow> windows = new ConcurrentHashMap<>();

    public synchronized boolean allowRequest(String key, int maxRequests, long windowSizeInMillis) {
        long currentTime = System.currentTimeMillis();
        windows.putIfAbsent(key, new SlidingWindow(windowSizeInMillis));
        
        SlidingWindow window = windows.get(key);
        return window.addRequest(currentTime, maxRequests);
    }

    private static class SlidingWindow {
        private final long windowSizeInMillis;
        private int currentCount;
        private long currentWindowStart;
        private int previousCount;
        private long previousWindowStart;

        public SlidingWindow(long windowSizeInMillis) {
            this.windowSizeInMillis = windowSizeInMillis;
            this.currentWindowStart = System.currentTimeMillis() / windowSizeInMillis * windowSizeInMillis;
            this.previousWindowStart = currentWindowStart - windowSizeInMillis;
        }

        public boolean addRequest(long currentTime, int maxRequests) {
            updateWindows(currentTime);
            
            // Calculate weighted count
            long currentWindowProgress = currentTime - currentWindowStart;
            double previousWindowWeight = (windowSizeInMillis - currentWindowProgress) / (double) windowSizeInMillis;
            double weightedCount = currentCount + previousCount * previousWindowWeight;
            
            if (weightedCount < maxRequests) {
                currentCount++;
                return true;
            }
            return false;
        }

        private void updateWindows(long currentTime) {
            long newWindowStart = currentTime / windowSizeInMillis * windowSizeInMillis;
            
            if (newWindowStart > currentWindowStart) {
                // Shift windows
                previousWindowStart = currentWindowStart;
                previousCount = currentCount;
                currentWindowStart = newWindowStart;
                currentCount = 0;
            }
        }
    }
}