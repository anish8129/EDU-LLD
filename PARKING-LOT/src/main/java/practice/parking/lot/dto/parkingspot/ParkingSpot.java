package practice.parking.lot.dto.parkingspot;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class ParkingSpot {
    private static final AtomicInteger uniqueId = new AtomicInteger(0);
    int id;
    int floorNum;
    int amount;
    boolean isFree;

    public ParkingSpot() {
    }

    public ParkingSpot(int floorNum, int amount) {
        this.floorNum = floorNum;
        this.amount = amount;
        isFree = true;
        id = uniqueId.incrementAndGet();
    }

    public int getFloorNum() {
        return floorNum;
    }

    public int getAmount() {
        return amount;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }

    public abstract int cost(int hours);

    public static ParkingSpot create(int floor) {
        return null;
    }
}
