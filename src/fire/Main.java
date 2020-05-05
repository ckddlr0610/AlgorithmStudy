/**
 * 백준 4179번 불!
 * 처음에 DFS, 재귀적으로 풀려고 했으나
 * 불과 사람이 움직이는 것을 동시에 풀어낼 수가 없었다
 * 동시에 움직이는 경우, 큐를 이용한 BFS로 접근해야한다.
 */

package fire;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;

public class Main {
    static String[][] room;
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int m;
    static int n;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int row = Integer.parseInt(bufferedReader.readLine());
        int column = Integer.parseInt(bufferedReader.readLine());

        m = row;
        n = column;

        room = new String[row][column];
        visited = new boolean[row][column];
        int j_x = 0;
        int j_y = 0;

        for (int i=0; i<row; i++) {
            String[] strings = bufferedReader.readLine().split("");
            for (int j=0; j<column; j++) {
                room[i][j] = strings[j];
                if (room[i][j].equals("J")) {
                    j_y = i;
                    j_x = j;
                }
            }
        }



        //move(j_y,j_x);
    }
/*
    static void move(int y, int x) {
        visited[y][x] = true;

        if (y==m-1 || x==n-1 || y==0 || x==0 ) {
            System.out.println("탈출가능");
            return;
        }

        if (room[y][x].equals("F")) {
            return;
        }

        for (int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (room[ny][nx].equals(".") && visited[ny][nx]!=true) {
                move(ny, nx);
            }
        }
    }

 */
}
