# Smart Traffic Control System Simulation

This Java project simulates an intelligent traffic signal control system that dynamically adapts to real-time traffic conditions and emergency vehicle detection. It models intersections as nodes in a traffic network, prioritizes emergency vehicles, and optimizes green-light durations to reduce congestion.

## Features

- **Traffic Queue Management:**  
  Manages queues of vehicles at intersections, tracking vehicle type (regular, public, emergency) and direction (north, south, east, west).

- **Emergency Vehicle Priority Scheduling:**  
  Uses a custom max heap data structure to prioritize intersections where emergency vehicles are detected, granting immediate green lights.

- **Traffic Network Graph:**  
  Models the city’s traffic network as a weighted graph with intersections as nodes and roads as edges. Supports shortest path rerouting for emergencies.

- **Simulation Rounds:**  
  Runs multiple simulation rounds adding random vehicles and emergency events to demonstrate dynamic traffic control.

## Project Structure

- `Main.java` — Main simulation logic, runs rounds, manages queues, emergencies, and routing.
- `Vehicles.java` — Represents vehicle objects with type and direction.
- `IntersectionQueue.java` — Custom list managing vehicles waiting at intersections.
- `MaxHeap.java` — Max heap implementation prioritizing emergency intersections.
- `EmergencyInterSection.java` — Emergency intersection data with priority values.
- `Graph.java` — Weighted graph representing city intersections and roads, with shortest path calculation.

## How to Run

1. Ensure you have Java JDK 11 or higher installed.
2. Clone this repository.
3. Compile all `.java` files:

   ```bash
   javac *.java
