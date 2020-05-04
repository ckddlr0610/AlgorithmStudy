/*
package colorbook;

import java.util.ArrayList;

class Solution {
    static boolean[][] visited;
    static int count;
    static ArrayList<Integer> aws = new ArrayList<>();
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] picture;

    public static void main(String[] args) {
        int m = 6;
        int n = 4;
        int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};

        int[] answer = solution(m,n,picture);

        for (int i : answer) {
            System.out.println(i);
        }
    }
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        visited = new boolean[m][n];

        int[] answer = new int[2];

        this.picture = picture;

        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++) {
                if (picture[i][j] != 0 || visited[i][j] != true) {
                    count = 0;
                    count = dfs(i, j, m, n, picture[i][j]);
                    numberOfArea++;
                    if (count>=maxSizeOfOneArea) {
                        maxSizeOfOneArea = count;
                    }
                }
            }
        }

        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    public static int dfs(int y, int x, int m, int n, int prev){
        int temp_count = 1;
        if (picture[y][x] != prev || visited[y][x] != false) return 0;
        visited[y][x] = true;

        for (int i=0; i<4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
        }
    }
}
*/
