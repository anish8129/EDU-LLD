package org.elevator.schedule.strategy;


import org.elevator.util.Elevator;

public interface SchedulingStrategy {
    // Determines the next stop for the given elevator
    int getNextStop(Elevator elevator);
}
