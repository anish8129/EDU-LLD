package org.example;

public class ApiResponse {
    private String message;
    private String algorithm;
    private long timestamp;

    public ApiResponse(String message, String algorithm, long timestamp) {
        this.message = message;
        this.algorithm = algorithm;
        this.timestamp = timestamp;
    }

    // Getters and setters
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
    
    public String getAlgorithm() { return algorithm; }
    public void setAlgorithm(String algorithm) { this.algorithm = algorithm; }
    
    public long getTimestamp() { return timestamp; }
    public void setTimestamp(long timestamp) { this.timestamp = timestamp; }
}