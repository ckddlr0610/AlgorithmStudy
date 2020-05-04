package makemaze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static int n;
    static ArrayList<Integer> result = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int[][] maze = new int[n][n];

        for (int i=0; i<n; i++) {
            String[] string = bufferedReader.readLine().split("");
            for (int j=0; j<n; j++) {
                maze[i][j] = Integer.parseInt(string[j]);
            }
        }

        int black = 0;
        dfs(0,0, black, maze);

        System.out.println(result);
    }

    public static void dfs(int y, int x, int black, int[][] maze) {
        if (y==n && x==n) {
            result.add(black);
            return;
        }

        if (y>=n || x>=n) {
            return;
        }

        if (maze[y+1][x]==1) {
            dfs(y+1,x,black,maze);
        }

        if (maze[y][x+1]==1) {
            dfs(y, x+1, black, maze);
        }

        if (maze[y+1][x]==0 && maze[y][x+1]==0) {
            dfs(y+1, x, black, maze);
            dfs(y, x+1, black, maze);
            black++;
        }



    }
}
