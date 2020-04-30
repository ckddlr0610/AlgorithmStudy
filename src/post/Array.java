package post;

import java.util.Scanner;

public class Array {
    static int[] count = new int[100]; // 학생 추천 수 보관
    static int[] frame;
    static int oldVote = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        frame = new int[num];
        int likeNum = scanner.nextInt();

        for (int i=0; i<likeNum; i++) {
            int like = Integer.parseInt(scanner.next());
            addPost(like);
        }

        for (int j=0; j<frame.length; j++) {
            System.out.print(frame[j]+ " ");
        }
    }

    public static void addPost(int sNum){
        for (int i=0; i<frame.length; i++){
            if (frame[i]==sNum){
                count[sNum]++; // 이미 등록되있으면 추천 수 증가
                return;
            }
        }
        for (int j=0; j<frame.length; j++) {
            if (frame[j]==0) {
                frame[j] = sNum; // 자리 비었으면 그 쪽에 학생 넣는다
                count[sNum]++;
                oldVote = j;
                return;
            }
        }
        int min = count[frame[0]];
        for (int z=0; z<frame.length; z++) {
            if (min > count[frame[z]]) {
                min = count[frame[z]]; // 가장 추천수가 적은 사람을 선정한다.
            }
        }
        for (int r=0; r<frame.length; r++) {
            if (count[frame[r]] == min && oldVote == r) {
                count[frame[r]] = 0;
                frame[r] = sNum;
                oldVote = r;
                return;
            }
        }
    }
}
