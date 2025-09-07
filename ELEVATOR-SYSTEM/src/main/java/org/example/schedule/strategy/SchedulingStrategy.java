package org.example.schedule.strategy;


import org.example.util.Elevator;

public interface SchedulingStrategy {
    // Determines the next stop for the given elevator
    int getNextStop(Elevator elevator);
}
