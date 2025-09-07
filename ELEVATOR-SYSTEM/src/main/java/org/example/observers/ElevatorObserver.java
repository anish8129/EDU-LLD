package org.example.observers;

import org.example.enums.ElevatorState;
import org.example.util.Elevator;

public interface ElevatorObserver {
    // Called when an elevator's state changes
    void onElevatorStateChange(Elevator elevator, ElevatorState state);

    // Called when an elevator changes its current floor
    void onElevatorFloorChange(Elevator elevator, int floor);
}
