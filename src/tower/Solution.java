/**
 * 시간 복잡도 문제
 * 중복이나 코드 개선을 하려고 했지만 동일한 테스트에서 시간 초과가 나온다
 * 자료구조 자체를 배열에서 스택/큐로 변환해야 할 것 같다.
 *
 * 스택으로 변경해서 성공
 * 배열을 스택으로 넣어주자
 * push pop을 잘써야되겠다.
 */

package tower;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        int[] heights = {3, 9, 9, 3, 5, 7, 2};

        int[] answer = solution(heights);

        for (int i = 0; i < heights.length; i++) {
            System.out.println(answer[i]);
        }
    }

    /*
    배열로 문제풀이한 코드입니다.
    static int[] solution(int[] heights) {
        int[] answer = {};
        int size = heights.length;

        answer = new int[size];

        for (int i=size-1; i>0; i--) {
            for (int j=i-1; j>0; j--){
                if (heights[i]<heights[j]){
                    answer[i] = j+1;
                    break;
                }
                if (j==0){
                    answer[i] = 0;
                }
            }
        }
        return answer;
    }
     */

    static int[] solution(int[] heights) {
        int[] answer = {};
        int size = heights.length;
        int count;
        int sender, receiver;
        Stack<Integer> stack = new Stack<>();
        answer = new int[size];

        for (int i = 0; i < size; i++) {
            stack.push(heights[i]);
        }

        for (int i = size-1; i>0; i--) {
            sender = stack.pop();
            count = 0;
            while (!(stack.empty())) {
                receiver = stack.pop();
                count++;
                if (sender < receiver) {
                    answer[i] = i-count+1;
                    break;
                }
            }
            for (int j=i-count; j<i; j++){
                stack.push(heights[j]);
            }
        }

        return answer;
    }
}
