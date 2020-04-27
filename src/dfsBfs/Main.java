package dfsBfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    //인접행렬로 구현합니다.
    static int map[][];
    static boolean[] visit;
    static int n,m,v;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        //연속 입력을 받고 각 입력을 토큰으로 나눕니다.
        StringTokenizer st = new StringTokenizer(s, " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());
        map = new int[n+1][n+1];
        visit = new boolean[n+1];
        for (int j=0; j<n+1; j++){
            Arrays.fill(map[j], 0);
        }
        Arrays.fill(visit,false);
        for (int i=0; i<m; i++){
            String edge = br.readLine();
            StringTokenizer st1 = new StringTokenizer(edge, " ");
            int a = Integer.parseInt(st1.nextToken());
            int b = Integer.parseInt(st1.nextToken());
            map[a][b] = 1;
            map[b][a] = 1;
        }
        dfs(v);
        System.out.println();
        Arrays.fill(visit,false);
        bfs(v);
    }

    public static void dfs(int i){
        //방문한 vertex를 true로 나타냅니다.
        visit[i] = true;
        System.out.print(i + " ");
        for (int j=1; j<n+1; j++){
            //인접행렬에서 1인 곳을 찾음과 동시에 해당 vertex가 방문한 적이 없는지 확인합니다.
            if (map[i][j]==1&&visit[j]==false){
                //해당 vertex로 이동해서 다시 탐색합니다.
                dfs(j);
            }
        }
    }

    public static void bfs(int i){
        Queue<Integer> queue = new LinkedList<Integer>();
        //해당 vertex를 큐에 넣습니다
        queue.offer(i);
        visit[i] = true;
        while(!queue.isEmpty()){
            int temp = queue.poll();
            System.out.print(temp + " ");
            //해당 vertex와 인접한 vertex를 모두 큐에 넣습니다.
            for (int k = 1; k<=n; k++){
                if (map[temp][k]==1&&visit[k]==false){
                    queue.offer(k);
                    visit[k] = true;
                }
            }
        }

    }
}
