package org.example.selection.strategy;

import java.util.List;
import org.example.enums.Direction;
import org.example.util.Elevator;

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
                // TODO: Check this Once

            }
        }
        return null;
    }
}
