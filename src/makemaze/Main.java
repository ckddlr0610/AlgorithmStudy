package makemaze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int x;
    int y;

    Node(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

public class Main {
    static Queue<Node> queue;
    static int[] dx = {1, 0};
    static int[] dy = {0, 1};
    static int[][] maze;
    static boolean[][] discovered;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        maze = new int[n][n];
        discovered = new boolean[n][n];

        for (int i=0; i<n; i++) {
            String[] string = bufferedReader.readLine().split("");
            for (int j=0; j<n; j++) {
                maze[i][j] = Integer.parseInt(string[j]);
            }
        }

    }

    static void bfs(int count) {
        queue = new LinkedList<>();

        while (!(queue.isEmpty())) {

            Node temp = queue.poll();
            for (int i = 0; i < 2; i++) {
                int ny = temp.y + dy[i];
                int nx = temp.x + dx[i];

                if (discovered[ny][nx] != true && maze[ny][nx]!=0) {
                    discovered[ny][nx] = true;
                    queue.offer(new Node(ny, nx));
                }
                

            }
        }
    }
}
