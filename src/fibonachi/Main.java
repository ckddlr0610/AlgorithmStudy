package fibonachi;

import java.util.Arrays;
import java.util.Scanner;

class Main {
    static long[] cache;
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int number = scanner.nextInt();
        cache = new long[number+1];
        Arrays.fill(cache, -1);
        long result = search(number);

        System.out.println(result);
    }

    public static long search(int n) {
        if (n==0) {
            return 0;
        }
        if (n==1) {
            return 1;
        }
        if (cache[n]!=-1) {
            return cache[n];
        }
        return cache[n] = search(n-1) + search(n-2);
    }
}
