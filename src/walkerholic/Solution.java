package walkerholic;

class Solution {
    int MOD = 20170805;
    static int[][] cityMap;
    static int m;
    static int n;
    static int result;
    static boolean[][] visited;
    public int solution(int m, int n, int[][] cityMap) {
        int answer = 0;
        this.cityMap = cityMap;
        this.m = m;
        this.n = n;
        visited = new boolean[m][n];
        return answer;
    }

    public static void dfs(int y, int x, int py, int px) {
        if ((y == m-1) && (x == n-1)) {
            result++;
        }

        switch (cityMap[y][x]) {
            case 0 :
                dfs(y, x+1, y, x);
                dfs(y+1, x, y, x);
                break;
            case 1 :
                return;
            case 2 :
                if (py == y-1) {
                    dfs(y+1, x, y, x);
                }
                if (px == x-1) {
                    dfs(y, x+1, y, x);
                break;
            }
        }
    }
}
