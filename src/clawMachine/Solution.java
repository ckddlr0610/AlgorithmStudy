/**
 * 2019 카카오 개발자 겨울 인턴십
 * 크레오 인형뽑기 게임
 * 스택 활용해서 해결
 * 반복문의 범위 체크와 인덱스 주의하기
 * 처음에 i를 i-1하지 않았고, 안쪽 for문의 break를 안걸었었다.
 */

package clawMachine;

import java.util.Stack;

class Solution {
    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> basket = new Stack<>();
        int oldDoll = 0;
        int newDoll = 0;

        for (int i : moves) {
            for (int j=0; j<board.length; j++) {
                if (!(board[j][i-1]==0)) {
                    if (!basket.isEmpty()){
                        oldDoll = basket.peek();
                    }
                    basket.push(board[j][i-1]);
                    newDoll = basket.peek();
                    if (oldDoll==newDoll) {
                        basket.pop();
                        basket.pop();
                        answer += 2;
                    }
                    board[j][i-1] = 0;
                    break;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args){
        int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};

        int answer = solution(board,moves);

        System.out.println(answer);
    }
}
