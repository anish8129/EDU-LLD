/*
 * Copyright 2025 Play Games24x7 Pvt. Ltd. All Rights Reserved
 */

package org.lld.model;

import java.util.ArrayList;
import java.util.List;


public class Player {
    int id;
    List<BattleItem> battleItems = new ArrayList<>();
    CoOrdinate start;
    CoOrdinate end;

    public Player(int id, CoOrdinate start, CoOrdinate end) {
        this.id = id;
        this.start = start;
        this.end = end;
    }

    public int getId() {
        return id;
    }

    public List<BattleItem> getBattleItems() {
        return battleItems;
    }

    public CoOrdinate getStart() {
        return start;
    }

    public CoOrdinate getEnd() {
        return end;
    }

    public boolean checkIsInRange(CoOrdinate coOrdinate) {
        return coOrdinate.getX() > start.getX() && coOrdinate.getX() < end.getX() && coOrdinate.getY() > start.getY() && coOrdinate.getY() < end.getY();
    }

    public String takeHit(CoOrdinate coOrdinate) {
        for (BattleItem ship : battleItems) {
            if (ship.takeHit(coOrdinate)) {
                return String.format("Player %s's item %s with id %s is Hit", id,ship.type(), ship.name());
            }
        }
        return "Missed";
    }

    public boolean isAllBattleItemDestroyed() {
        return battleItems.stream().allMatch(BattleItem::isDestroyed);
    }

    public void addShip(BattleItem ship) {
        for(BattleItem sip : battleItems) {
            if (sip.isOverlapping(ship)) {
                throw new IllegalArgumentException("Getting Overlaped");
            }
        }
        battleItems.add(ship);
    }
}
