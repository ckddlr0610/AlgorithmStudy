/**
 * 백준 2798번 블랙잭 문제
 * 재귀함수로 접근했는데, 두번째 테스트 케이스에서 값이 안맞는다
 * 원인을 아직 모르겠음
 */

package blackjack;

import java.util.Scanner;

public class Main {
    private static int r = 3;
    private static int n;
    private static int m;
    private static int maxSum = 0;

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        n = Integer.parseInt(scanner.next());
        m = Integer.parseInt(scanner.next());

        int[] arr = new int[n];
        boolean[] visited = new boolean[n];

        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(scanner.next());
        }

        combination(arr, visited, 0, n, r, m);
        System.out.println(maxSum);
    }

    public static void combination(int[] arr, boolean[] visited, int start, int n, int r, int m){
        if (r==0) {
            int sum=0;
            for (int i=0; i<n; i++){
                if (visited[i]) {
                    sum += arr[i];
                }
            }
            if (sum>maxSum && sum<=m) {
                maxSum = sum;
            }
            return;
        }

        for (int i=start; i<n; i++){
            visited[i] = true;
            combination(arr, visited, start+1, n, r-1, m);
            visited[i] = false;
        }
    }
}
