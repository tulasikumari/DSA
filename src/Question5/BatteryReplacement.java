package Question5;

import java.util.Collections;
import java.util.PriorityQueue;
//5b
//Assume an electric vehicle must go from source city s to destination city d. You can locate many service centers
//        along the journey that allow for the replacement of batteries; however, each service center provides batteries with a
//        specific capacity. You are given a 2D array in which servicecenter[i]=[xi,yj] indicates that the ith service center is
//        xi miles from the source city and offers yj miles after the automobile can travel after replacing batteries at specific
//        service centers. Return the number of times the car's batteries need to be replaced before arriving at the destination.
//        Input: serviceCenters = [{10,60},{20,30},{30,30},{60,40}], targetMiles= 100, startChargeCapacity = 10
//        Output: 2
//        Explanation: The car can go 10 miles on its initial capacity; after 10 miles, the car replaces batteries with a
//        capacity of 60 miles; and after travelling 50 miles, at position 60 we change batteries with a capacity of 40 miles;
//        and ultimately, we may arrive at our destination.
////5b
public class BatteryReplacement {
    public int batteryReplacement(int[][] serviceCenters, int targetMiles, int startChargeCapacity) {
        int count = 0; // count of battery replacements
        int currentPos = 0; // current position of the car
        int currentCapacity = startChargeCapacity; // current capacity of the car's battery

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // max heap to store battery capacities

        for (int i = 0; i < serviceCenters.length; i++) {
            int pos = serviceCenters[i][0];
            int capacity = serviceCenters[i][1];

            // if the service center is before the current position, ignore it
            if (pos <= currentPos) {
                continue;
            }

            int distance = pos - currentPos; // distance to the next service center

            // travel as far as possible with the current capacity
            while (distance > currentCapacity) {
                // if the battery capacity heap is empty, return -1
                if (pq.isEmpty()) {
                    return -1;
                }
                currentCapacity = pq.poll(); // remove the largest battery capacity from the heap
                count++; // increment the count of battery replacements
            }

            // travel the remaining distance to the next service center
            currentPos = pos;
            currentCapacity -= distance;
            pq.offer(capacity); // add the battery capacity of the next service center to the heap
        }

        // travel the remaining distance to the destination
        while (targetMiles - currentPos > currentCapacity) {
            // if the battery capacity heap is empty, return -1
            if (pq.isEmpty()) {
                return -1;
            }
            currentCapacity = pq.poll(); // remove the largest battery capacity from the heap
            count++; // increment the count of battery replacements
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] serviceCenters = {{10,60},{20,30},{30,30},{60,40}};
        int targetMiles = 100;
        int startChargeCapacity = 10;
        BatteryReplacement br = new BatteryReplacement();
        int count = br.batteryReplacement(serviceCenters, targetMiles, startChargeCapacity);
        System.out.println(count); // output: 2
    }
}