package network;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static boolean[] visited;
    static int count;

    public static void main(String[] args) {
        int n = 4;
        int[][] computers ={{1, 0, 0, 0}, {0, 1, 0, 0}, {0, 0, 1, 0}, {0,0,0,1}};

        int result = solution(n, computers);

        System.out.println(result);
    }

    public static int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        count = 0;

        for (int i=0; i<n; i++) {
            computers[i][i] = 0;
        }

        for (int i=0; i<n; i++) {
            if (visited[i]!=true) {
                bfs(computers, 0, n);
            }
        }

        answer = count;
        return answer;
    }

    static void bfs(int[][] computers,int n, int size) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(n);
        visited[n] = true;

        while (!queue.isEmpty()) {
            n = queue.poll();

            for (int i=0; i<size; i++) {
                if (computers[n][i] == 1 && visited[i]!=true) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }

        count++;
    }
}
