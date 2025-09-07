/*
 * Copyright 2025 Play Games24x7 Pvt. Ltd. All Rights Reserved
 */

package org.elevator.selection.strategy;

import org.elevator.enums.Direction;
import org.elevator.util.Elevator;

public interface ElevatorSelectionStrategy {

    Elevator getElevator(int floorNo, Direction direction);

}
