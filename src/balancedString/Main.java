package balancedString;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] answerAry = new int[n];
        dfs(0, n, answerAry);
    }

    public static void dfs(int depth, int n, int[] answerAry) {
        if(depth == n) {
            for(int i = 0; i < n; i++) {
                System.out.print(answerAry[i] + " ");
            }
            System.out.println();
            return;
        }
        //answerAry[depth] = 0;
        dfs(depth+1, n, answerAry);
        answerAry[depth] = 1;
        dfs(depth+1, n, answerAry);
    }
}
