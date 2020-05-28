package happy;

import java.util.Scanner;

public class Main {
    static int max = 0;
    static int min = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = scanner.nextInt();
        int[] arr = new int[number];
        for (int i=0; i<number; i++) {
            arr[i] = scanner.nextInt();
        }

        if (number==2) {
            System.out.println(Math.abs(arr[1]-arr[0]));
        } else {
            int resMax = maxSearch(arr);
            int rexMin = minSearch(arr);

            System.out.println(resMax-rexMin);
        }
    }

    public static int maxSearch(int[] arr) {
        if (arr.length!=0) {
            max = arr[0];
        }

        for (int i=1; i<arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }

        return max;
    }

    public static int minSearch(int[] arr) {
        if (arr.length!=0) {
            min = arr[0];
        }

        for (int i=1; i<arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
        }

        return min;
    }
}
