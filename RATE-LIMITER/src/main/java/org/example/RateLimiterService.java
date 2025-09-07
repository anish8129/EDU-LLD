package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RateLimiterService {
    @Autowired
    private TokenBucket tokenBucket;
    
    @Autowired
    private LeakyBucket leakyBucket;
    
    @Autowired
    private FixedWindowCounter fixedWindowCounter;
    
    @Autowired
    private SlidingWindowLog slidingWindowLog;
    
    @Autowired
    private SlidingWindowCounter slidingWindowCounter;

    public boolean allowTokenBucketRequest(String key) {
        return tokenBucket.allowRequest(key, 10, 1);
    }

    public boolean allowLeakyBucketRequest(String key) {
        return leakyBucket.allowRequest(key, 10, 1);
    }

    public boolean allowFixedWindowRequest(String key) {
        return fixedWindowCounter.allowRequest(key, 10, 60000); // 10 requests per minute
    }

    public boolean allowSlidingWindowLogRequest(String key) {
        return slidingWindowLog.allowRequest(key, 10, 60000); // 10 requests per minute
    }

    public boolean allowSlidingWindowCounterRequest(String key) {
        return slidingWindowCounter.allowRequest(key, 10, 60000); // 10 requests per minute
    }
}