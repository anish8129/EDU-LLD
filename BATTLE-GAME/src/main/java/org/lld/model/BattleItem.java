/*
 * Copyright 2025 Play Games24x7 Pvt. Ltd. All Rights Reserved
 */

package org.lld.model;

public interface BattleItem {

    String type();

    String name();
    boolean isDestroyed();

    boolean isOverlapping(BattleItem battleItems);

    CoOrdinate start();

    CoOrdinate end();

    boolean takeHit(CoOrdinate coOrdinate);

}
