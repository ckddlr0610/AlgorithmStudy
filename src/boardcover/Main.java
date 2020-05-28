package boardcover;

public class Main {
    static int answer;
    static int h;
    static int w;
    public static void main(String[] args) {

    }

    public static void dfs(String[][] boards, int total, int cnt, int y, int x) {
        if (cnt==total) {
            answer++;
            return;
        }

        for (int i=1; i<h-1; i++) {
            for (int j=1; j<w-1; j++) {
                if (boards[y][x+1]=="."&&boards[y+1][x]==".") {

                }
                //if (boards[])
            }
        }
    }
}
