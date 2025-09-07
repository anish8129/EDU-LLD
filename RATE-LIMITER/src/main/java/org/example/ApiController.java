package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {
    @Autowired
    private RateLimiterService rateLimiterService;

    @GetMapping("/api/token-bucket/{key}")
    public ResponseEntity<ApiResponse> tokenBucketEndpoint(@PathVariable String key) {
        boolean allowed = rateLimiterService.allowTokenBucketRequest(key);
        return createResponse(allowed, "Token Bucket Algorithm");
    }

    @GetMapping("/api/leaky-bucket/{key}")
    public ResponseEntity<ApiResponse> leakyBucketEndpoint(@PathVariable String key) {
        boolean allowed = rateLimiterService.allowLeakyBucketRequest(key);
        return createResponse(allowed, "Leaky Bucket Algorithm");
    }

    @GetMapping("/api/fixed-window/{key}")
    public ResponseEntity<ApiResponse> fixedWindowEndpoint(@PathVariable String key) {
        boolean allowed = rateLimiterService.allowFixedWindowRequest(key);
        return createResponse(allowed, "Fixed Window Counter Algorithm");
    }

    @GetMapping("/api/sliding-window-log/{key}")
    public ResponseEntity<ApiResponse> slidingWindowLogEndpoint(@PathVariable String key) {
        boolean allowed = rateLimiterService.allowSlidingWindowLogRequest(key);
        return createResponse(allowed, "Sliding Window Log Algorithm");
    }

    @GetMapping("/api/sliding-window-counter/{key}")
    public ResponseEntity<ApiResponse> slidingWindowCounterEndpoint(@PathVariable String key) {
        boolean allowed = rateLimiterService.allowSlidingWindowCounterRequest(key);
        return createResponse(allowed, "Sliding Window Counter Algorithm");
    }

    private ResponseEntity<ApiResponse> createResponse(boolean allowed, String algorithm) {
        if (allowed) {
            return ResponseEntity.ok(new ApiResponse("Request allowed", algorithm, System.currentTimeMillis()));
        } else {
            return ResponseEntity.status(429)
                    .body(new ApiResponse("Rate limit exceeded", algorithm, System.currentTimeMillis()));
        }
    }
}