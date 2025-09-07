package practice.parking.lot.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import practice.parking.lot.dto.parkingspot.ParkingSpot;
import practice.parking.lot.enums.ParkingSpotEnum;

public class ParkingLot {
    private String name;
    private List<Exits> exists;
    private List<Exits> entrance;
    private DisplayBoard displayBoard;
    private Map<ParkingSpotEnum, List<ParkingSpot>> freeParkingSpots;
    private Map<ParkingSpotEnum, List<ParkingSpot>> occupiedParkingSpots;

    private static ParkingLot parkingLot = null;

    private ParkingLot(String name) {
        this.name = name;
        this.exists = new ArrayList<>();
        this.entrance = new ArrayList<>();
        this.displayBoard = DisplayBoard.getInstance();
        this.freeParkingSpots = new HashMap<>();
        this.occupiedParkingSpots = new HashMap<>();
    }

    public static ParkingLot getInstance() {
        if (parkingLot == null) {
            parkingLot = new ParkingLot("Parking-Lot-1");
        }
        return parkingLot;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Exits> getExists() {
        return exists;
    }

    public void setExists(List<Exits> exists) {
        this.exists = exists;
    }

    public List<Exits> getEntrance() {
        return entrance;
    }

    public void setEntrance(List<Exits> entrance) {
        this.entrance = entrance;
    }

    public DisplayBoard getDisplayBoard() {
        return displayBoard;
    }

    public void setDisplayBoard(DisplayBoard displayBoard) {
        this.displayBoard = displayBoard;
    }

    public Map<ParkingSpotEnum, List<ParkingSpot>> getFreeParkingSpots() {
        return freeParkingSpots;
    }

    public void setFreeParkingSpots(
            Map<ParkingSpotEnum, List<ParkingSpot>> freeParkingSpots) {
        this.freeParkingSpots = freeParkingSpots;
    }

    public Map<ParkingSpotEnum, List<ParkingSpot>> getOccupiedParkingSpots() {
        return occupiedParkingSpots;
    }

    public void setOccupiedParkingSpots(
            Map<ParkingSpotEnum, List<ParkingSpot>> occupiedParkingSpots) {
        this.occupiedParkingSpots = occupiedParkingSpots;
    }
}
