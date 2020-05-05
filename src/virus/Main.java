/**
 * 백준 2606번 바이러스
 * bfs 구현 연습하기 좋다
 * 인접행렬로 구현 할 때 인덱스의 범위에 대해서 주의하자
 */

package virus;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static boolean[] discovered;
    static int computer;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int vertex = scanner.nextInt();
        int edge = scanner.nextInt();

        int[][] matrix = new int[vertex+1][vertex+1];
        discovered = new boolean[vertex+1];
        computer = 0;

        Arrays.fill(discovered, false);

        for (int i=1; i<=edge; i++) {
            int start = Integer.parseInt(scanner.next());
            int end = Integer.parseInt(scanner.next());

            matrix[start][end] = 1;
            matrix[end][start] = 1;
        }

        bfs(matrix, discovered, 1);

        System.out.println(computer);
    }

    static void bfs(int[][] matrix, boolean[] discovered, int v) {
        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        discovered[v] = true;

        while (!q.isEmpty()) {
            v = q.poll();

            for (int i=1; i<discovered.length; i++) {
                if (matrix[v][i]==1 && discovered[i]!=true) {
                    q.add(i);
                    discovered[i] = true;
                    computer++;
                }
            }
        }
    }
}
