/*
 * Copyright 2025 Play Games24x7 Pvt. Ltd. All Rights Reserved
 */

package org.example.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.example.dto.vehicle.Vehicle;
import org.example.dto.ParkingEvent;
import org.example.dto.ParkingLot;
import org.example.dto.ParkingTicket;
import org.example.dto.parkingspot.ParkingSpot;
import org.example.dto.parkingspot.spot.decorator.Electric;
import org.example.dto.parkingspot.spot.decorator.Wash;
import org.example.enums.ParkingEventType;
import org.example.enums.ParkingSpotEnum;
import org.example.service.DisplayService;
import org.example.service.Observer;
import org.example.service.ParkingLotService;
import org.example.service.ParkingStrategy;

public class ParkingLotServiceImpl implements ParkingLotService {
    ParkingStrategy parkingStrategy;
    ParkingLot parkingLot;
    DisplayService displayService;
    List<Observer> observers;

    public ParkingLotServiceImpl(ParkingStrategy parkingStrategy, DisplayServiceImpl displayService) {
        this.parkingStrategy = parkingStrategy;
        parkingLot = ParkingLot.getInstance();
        this.displayService = displayService;
        observers = new ArrayList<>();
    }

    @Override
    public ParkingTicket entry(Vehicle vehicle) {
        ParkingSpotEnum parkingSpotEnum = vehicle.getSupportedParkingSpot();
        List<ParkingSpot> freeParkingSpot = parkingLot.getFreeParkingSpots().get(parkingSpotEnum);
        List<ParkingSpot> occupiedParkingSpot = parkingLot.getOccupiedParkingSpots().get(parkingSpotEnum);
        try {
            ParkingSpot parkingSpot = parkingStrategy.findParkingSpot(parkingSpotEnum);
            if (parkingSpot.isFree()) {
                synchronized (parkingSpot) {
                    if (parkingSpot.isFree()) {
                        parkingSpot.setFree(false);
                        freeParkingSpot.remove(parkingSpot);
                        occupiedParkingSpot.add(parkingSpot);
                        ParkingTicket  parkingTicket = new ParkingTicket(vehicle, parkingSpot);
                        ParkingEvent parkingEvent = new ParkingEvent(ParkingEventType.ENTRY, parkingSpotEnum);
                        notifyAllObservers(parkingEvent);
                        return parkingTicket;
                    }
                    entry(vehicle);
                }
            }
        } catch (RuntimeException spotNotFound) {
            throw spotNotFound;
        }
        return null;
    }

    public void addObservers(Observer observer) {
        observers.add(observer);
    }

    public void notifyAllObservers(ParkingEvent parkingEvent) {
        for (Observer observer : observers) {
            observer.update(parkingEvent);
        }
    }

    public void addWash(ParkingTicket parkingTicket) {
        parkingTicket.setParkingSpot(new Wash(parkingTicket.getParkingSpot()));
    }

    public void addChargingFacility(ParkingTicket parkingTicket) {
        parkingTicket.setParkingSpot(new Electric(parkingTicket.getParkingSpot()));
    }

    @Override
    public int exit(ParkingTicket parkingTicket, Vehicle vehicle) {
        if (parkingTicket.getVehicle().equals(vehicle)) {
            ParkingSpot parkingSpot = parkingTicket.getParkingSpot();
            int amount  = parkingSpot.getAmount();
            parkingSpot.setFree(true);
            ParkingSpotEnum parkingSpotEnum = vehicle.getSupportedParkingSpot();
            parkingLot.getOccupiedParkingSpots().get(parkingSpotEnum).remove(parkingSpot);
            addParkingSpotInFreeList(parkingLot.getFreeParkingSpots().get(parkingSpotEnum), parkingSpot);
            ParkingEvent parkingEvent = new ParkingEvent(ParkingEventType.EXIT, parkingSpotEnum);
            notifyAllObservers(parkingEvent);
            return amount;
        }

        return 0;

    }

    private void addParkingSpotInFreeList(List<ParkingSpot> freeParkingSpots, ParkingSpot parkingSpot) {
        freeParkingSpots.add(parkingSpot);
    }
}
