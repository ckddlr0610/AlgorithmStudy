package bridgeTruck;

import java.util.LinkedList;
import java.util.Queue;

class Car {
    int entryTime;
    int weight;

    Car(int weight, int entryTime) {
        this.weight = weight;
        this.entryTime = entryTime;
    }

}

class Solution {
    public static void main(String[] args) {
        int length = 2;
        int weight = 10;
        int[] truck = {7,4,5,6};

        int time = solution(length,weight,truck);

        System.out.println(time);
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int time = 0;
        int currentWei = 0;

        Queue<Car> bridge = new LinkedList<>();
        Queue<Car> waiting = new LinkedList<>();

        for (int i=0; i<truck_weights.length; i++) {
            waiting.offer(new Car(truck_weights[i], 0));
        }

        int index = 0;
        do {
            time++;

            if (!bridge.isEmpty()){
                Car truck = bridge.peek();
                if ((time-truck.entryTime >= bridge_length)) {
                    currentWei -= truck.weight;
                    bridge.poll();
                }
            }

            if (!waiting.isEmpty()) {
                if (currentWei + waiting.peek().weight <= weight) {
                    Car inputTruck = waiting.poll();
                    currentWei += inputTruck.weight;
                    bridge.offer(new Car(inputTruck.weight, time));
                }
            }

        } while (!bridge.isEmpty());

        answer = time;

        return answer;
    }
}
