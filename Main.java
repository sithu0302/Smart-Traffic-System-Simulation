import java.util.Random;


public class Main {
    public static void main(String[] args) {

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println(" SMART TRAFFIC CONTROL SYSTEM SIMULATION");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
        

        IntersectionQueue queue = new IntersectionQueue();
        MaxHeap emergencyHeap = new MaxHeap();
        Graph cityGraph = new Graph();

        // === Setup City Graph 
        cityGraph.addEdge("A", "B", 5);
        cityGraph.addEdge("A", "C", 2);
        cityGraph.addEdge("B", "D", 1);
        cityGraph.addEdge("C", "D", 7);
        cityGraph.addEdge("B", "E", 3);
        cityGraph.addEdge("D", "E", 1);

        // === Simulation Rounds ===
        int simulationRounds = 3;

        for (int round = 1; round <= simulationRounds; round++) {
            System.out.println("\n===== Simulation Round " + round + " =====");

            // 1. Add Random Vehicles
            addRandomVehicles(queue, 3);

            // 2. Add Random Emergency Intersection 
            addRandomEmergency(emergencyHeap);

            // 3. Print Current Queue Status
            System.out.println("\n Current Vehicle Queue:");
            System.out.println("Total Vehicles: " + queue.getTotalVehicleCount());
            System.out.println("Emergency Vehicles: " + queue.getVehiclesCountByType("emergency"));
            queue.displayVehicles();

            // 4. Emergency Intersections
            System.out.println("\n Emergency Priority Queue:");
            emergencyHeap.displayHeap();

            // 5. Handle Highest Priority
            EmergencyInterSection top = emergencyHeap.extractMax();
            if (top != null) {
                System.out.println("\n Green Light Given to: " + top.name + " (Priority " + top.priority + ")");
            } else {
                System.out.println("\n  No emergencies to prioritize in this round.");
            }
        }

        // === Final Graph View + Emergency Path ===
        System.out.println("\n\n  City Traffic Network (Graph):");
        cityGraph.displayGraph();

        System.out.println("\n Emergency Rerouting From A to Hospital E:");
        cityGraph.shortestPath("A", "E");
    }

    // Helper 1: Random Vehicles
    public static void addRandomVehicles(IntersectionQueue queue, int count) {
        String[] types = {"regular", "public", "emergency"};
        String[] directions = {"north", "south", "east", "west"};
        Random rand = new Random();

        for (int i = 0; i < count; i++) {
            String type = types[rand.nextInt(types.length)];
            String direction = directions[rand.nextInt(directions.length)];
            Vehicles v = new Vehicles(type, direction);
            queue.addVehicle(v);
            System.out.println("🚗 Detected: " + v);
        }
    }

    // Helper 2: Random Emergency Insert
    public static void addRandomEmergency(MaxHeap heap) {
        String[] names = {"Intersection A", "Intersection B", "Intersection C", "Intersection D"};
        Random rand = new Random();

        // 50% chance to generate emergency
        if (rand.nextBoolean()) {
            String name = names[rand.nextInt(names.length)];
            int priority = rand.nextInt(5) + 1; // 1 to 5
            EmergencyInterSection e = new EmergencyInterSection(name, priority);
            heap.insert(e);
            System.out.println(" Emergency Detected at " + name + " (Priority " + priority + ")");
        } else {
            System.out.println(" No emergency detected this round.");
        }
    }
}
