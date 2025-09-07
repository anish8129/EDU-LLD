# Parking Lot System Requirements

## Overview
A parking lot is a designated area for parking vehicles, commonly found in venues like shopping malls, sports stadiums, and office buildings. It consists of a fixed number of parking spots allocated for different types of vehicles. Each spot is charged based on the duration a vehicle remains parked. Parking time is tracked using a parking ticket issued at the entrance. Upon exit, the customer can pay using either an automated exit panel or through a parking agent, with credit/debit cards or cash as accepted payment methods.

## Requirements

### R1: Capacity
- The parking lot must support a total capacity of up to **40,000 vehicles**.

### R2: Parking Spot Types
The parking lot must support multiple types of parking spots:
- **Accessible** (for individuals with disabilities)
- **Compact**
- **Large**
- **Motorcycle**

### R3: Entrance and Exit Points
- The parking lot should provide **multiple entrance and exit points** to support efficient traffic flow.

### R4: Supported Vehicle Types
The system must support parking for the following vehicle types:
- Cars
- Trucks
- Vans
- Motorcycles

### R5: Display Boards
- A **display board** at each entrance and on every floor should show the current number of **available parking spots** for each parking spot type.

### R6: Maximum Capacity Enforcement
- The system must **not allow more vehicles to enter** once the parking lot reaches its maximum capacity.

### R7: Full Occupancy Notification
- When the parking lot is fully occupied, a **clear message** should be shown at each entrance and on all parking lot display boards.

### R8: Parking Ticket System
- Customers must be issued a **parking ticket at entry**, which will be used to track parking time and calculate payment at exit.

### R9: Payment at Exit
- Customers should be able to pay for parking at the **automated exit panel**.

### R10: Configurable Pricing
- The parking lot system must support **configurable pricing rates** based on:
    - Vehicle type
    - Parking spot type
    - Different rates for different parking durations (e.g., first hour, subsequent hours).

### R11: Payment Methods
- Payments must be accepted via:
    - **Credit/Debit Card**
    - **Cash**  
      at all payment points.

---

This document outlines the core requirements for the Parking Lot System. Further details on implementation, design, and additional features may be added as needed.