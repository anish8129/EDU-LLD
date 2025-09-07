# Elevator System Requirements

## Overview
Elevators are essential in multi-story buildings, enabling the efficient movement of people and goods. A typical system includes one or more elevator cars that respond to user requests from call buttons on each floor and destination selections inside the car.

To ensure efficiency and safety, an elevator system must:
- Handle requests intelligently to minimize passenger wait times.
- Respect car capacity and support centralized/decentralized control.
- Manage concurrent requests and optimize car movements.
- Provide real-time feedback through displays inside and outside the cars.
- Implement robust safety protocols for emergencies (e.g., power failures, fire alarms).

---

## Requirements

### **R1: Configurable Floors and Elevator Cars**
- The system shall support:
    - A **configurable number of floors (up to 15)**.
    - A **configurable number of elevator cars (up to 3)**.

### **R2: Elevator Car States**
- Each elevator car shall:
    - Serve **every floor**.
    - Exist in one of **four states**:
        - Moving up
        - Moving down
        - Maintenance
        - Idle

### **R3: Door Control**
- Elevator doors shall:
    - **Only open when the car is idle**.
    - **Auto-close after a configurable timeout**, unless the "Open" button is actively held.

### **R4: Floor Panel**
- Each floor shall have:
    - **Up/Down call buttons**.
    - **Indicator lights** (showing elevator arrival).
    - **External display** showing the car’s current floor and direction.

### **R5: Elevator Car Controls**
- Each elevator car shall include:
    - **Buttons for every floor (0 to 15)**.
    - **"Open," "Close," and emergency-stop buttons**.
    - **Internal display** showing:
        - Current floor
        - Direction
        - Load status

### **R6: Emergency Stop**
- Pressing the emergency-stop button shall:
    - **Immediately halt the car**.
    - **Keep doors closed**.
    - **Alert building security/operators**.

### **R7: Load Management**
- Each elevator car shall:
    - **Enforce a maximum load of 680 kg**.
    - **Inhibit motion if overloaded**.
    - **Emit an audible & visual alarm when overloaded**.

### **R8: Centralized Request Handling**
- The **central controller** shall:
    - Assign the **most appropriate car** to each floor-call request.
    - Aim to **minimize average wait time**.

### **R9: Concurrent Passenger Handling**
- The system shall support:
    - **Multiple passenger requests**.
    - Passengers going to **same or different floors** (same or opposite directions).

### **R10: Maintenance Mode**
- The system shall support a **maintenance state** for each car where:
    - **R10a:** The car is **removed from normal dispatch** (no new requests assigned).
    - **R10b:** All **doors remain closed**, and **panel inputs are ignored**.
    - **R10c:** All UIs display **"Maintenance"** for that car.
    - **R10d:** Upon exiting maintenance, the car **returns to idle state** at its current floor before resuming service.

### **R11: Real-Time Displays**
- All **internal & external displays** shall update in real time to show:
    - Current floor
    - Direction
    - Operational state (**idle, moving, maintenance, emergency**)

### **R12: Status Communication**
- The system shall **communicate all operational states, errors, and safety messages** via:
    - **Audio/visual indicators**.
    - **Displays** (ensuring passengers are always aware of elevator status).

---

This document outlines the core functional and operational requirements for the Elevator System. Additional details on implementation, safety protocols, and edge cases may be expanded in further design documentation.