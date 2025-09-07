/*
 * Copyright 2025 Play Games24x7 Pvt. Ltd. All Rights Reserved
 */

package org.example.selection.strategy;

import org.example.enums.Direction;
import org.example.util.Elevator;

public interface ElevatorSelectionStrategy {

    Elevator getElevator(int floorNo, Direction direction);

}
