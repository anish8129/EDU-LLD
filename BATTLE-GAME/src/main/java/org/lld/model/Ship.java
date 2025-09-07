/*
 * Copyright 2025 Play Games24x7 Pvt. Ltd. All Rights Reserved
 */

package org.lld.model;

public class Ship implements BattleItem {
    private final String name;
    private int size;
    private final CoOrdinate center;
    private CoOrdinate start;
    private CoOrdinate end;

    private boolean isDestroyed;

    public Ship(String name,int size, int x, int y) {
        this.name = name;
        this.size = size;
        this.center = new CoOrdinate(x, y);
        int halfSize = size /2;
        start = new CoOrdinate(x - halfSize, y - halfSize);
        end = new CoOrdinate(x + halfSize, y + halfSize);
    }

    @Override
    public String type() {
        return "SHIP";
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public boolean isDestroyed() {
        return isDestroyed;
    }

    @Override
    public boolean isOverlapping(BattleItem battleItem) {
        return checkInRange(battleItem.start()) || checkInRange(battleItem.end());
    }

    private boolean checkInRange(CoOrdinate coOrdinate) {
        return coOrdinate.getX() > start.getX() && coOrdinate.getX() < end.getX() && coOrdinate.getY() > start.getY() && coOrdinate.getY() < end.getY();
    }

    @Override
    public CoOrdinate start() {
        return start;
    }

    @Override
    public CoOrdinate end() {
        return end;
    }

    @Override
    public boolean takeHit(CoOrdinate coOrdinate) {
        if (isDestroyed()) {
            return false;
        }

        if (checkInRange(coOrdinate)) {
            isDestroyed = true;
        }
        return isDestroyed;
    }
}
