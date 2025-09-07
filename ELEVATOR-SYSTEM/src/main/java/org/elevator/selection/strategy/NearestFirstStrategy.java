/*
 * Copyright 2025 Play Games24x7 Pvt. Ltd. All Rights Reserved
 */

package org.elevator.selection.strategy;

import java.util.List;
import org.elevator.enums.Direction;
import org.elevator.util.Elevator;

public class NearestFirstStrategy implements ElevatorSelectionStrategy {

    List<Elevator> elevatorList;



    @Override
    public Elevator getElevator(int floorNo, Direction direction) {
        Elevator selectedElevator = null;
        for (Elevator elevator : elevatorList) {
            if (direction == Direction.UP && elevator.getCurrentFloor() < floorNo && elevator.getDirection() == Direction.UP) {
                if (selectedElevator != null) {
                    selectedElevator = (floorNo -selectedElevator.getCurrentFloor()) >  (floorNo - elevator.getCurrentFloor()) ? elevator : selectedElevator;
                } else {
                    selectedElevator = elevator;
                }
            } else if (direction == Direction.DOWN && elevator.getCurrentFloor() > floorNo && elevator.getDirection() == Direction.DOWN) {
                if (selectedElevator != null) {
                    selectedElevator = (selectedElevator.getCurrentFloor() - floorNo) >  (elevator.getCurrentFloor() - floorNo) ? elevator : selectedElevator;
                } else {
                    selectedElevator = elevator;
                }
            } else {
                // all are idle
                if ()


            }
        }
    }
}
