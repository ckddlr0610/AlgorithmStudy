package NandM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
public class Main {
    public static void main(String[] args){
        // 고른 수
        int count;
        // 현재 선택한 수
        int target;
        // 골라야 할 수 M
        int maxNum;
        // 전체 수열 N
        int selectNum;
        int[] answer;
        int[] array;
        Scanner scanner = new Scanner(System.in);

        selectNum = Integer.parseInt(scanner.next());
        maxNum = Integer.parseInt(scanner.next());

        array = new int[selectNum];
        answer = new int[maxNum];

        for (int i=0; i<selectNum; i++){
            array[i] = i+1;
        }

        search(0,0,0, maxNum, answer, array);
    }

    static void search(int index, int count, int target, int maxNum, int[] answer, int[] array){
        //M개만큼 모든 수를 골랐을 때
        if (count == maxNum){
            for (int i=0; i<count; i++){
                System.out.print(answer[i]+" ");
            }
            System.out.println();
        }
        //입력받은 수열을 다 탐색했을 때
        if (target>array.length) return;

        if (!(target==0)){
            answer[index] = target;
        }
        //다음 target을 선택하는 경우
        search(index+1, count+1, target+1, maxNum, answer, array);
        //다음 target을 선택하지 않는 경우
        search(index, count, target+1, maxNum, answer, array);
    }

     */
    public class Main {
        static int[] arr;
        static boolean[] visit;
        static StringBuilder sb = new StringBuilder();

        private static void dfs(int n, int m, int d) {
            if(d == m) {
                for(int a : arr) sb.append(a + " ");
                sb.append("\n");
                return;
            }

            for(int i = 1; i <= n; i++) {
                if(!visit[i]) {
                    visit[i] = true;
                    arr[d] = i;
                    dfs(n, m, d+1);
                    //visit[i] = false;
                }
            }
            return;
        }

        public static void main(String[] args) throws IOException {
            StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
            int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
            arr = new int[m]; visit = new boolean[n+1];

            dfs(n, m, 0);
            System.out.print(sb);
        }
    }
