/**
 * 이진탐색을 활용한 문제
 * 구하는 과정은 접근한 것 같은데 예외처리가 안된 것 같다
 * 일부 테스트가 오류가 나오는데 원인을 모르겠다
 */

package budget;

import java.util.Arrays;

class Solution {
    public static int solution(int[] budgets, int M) {
        int answer = 0;

        Arrays.sort(budgets);

        int plan;
        int left = (M/budgets.length);
        int right = budgets[budgets.length-1];

        /*
        최소 예정 금액도 M을 요청 수만큼 나눴을 때보다 크면 모든 요청이 상한선에 맞춰줘야 한다. 따라서 M을 요청 수만큼 나눈 값이 상한값이 됨.
         */
        if (budgets[0]>left) {
            answer = left;
            return answer;
        }

        /*
        모든 예정 금액을 더한 값이 M보다 작으면 최대 예정 금액이 상한 값이 된다.
         */
        int sum=0;
        for (int i=0; i<budgets.length; i++) {
            sum = sum+ budgets[i];
        }
        if (sum<=M) {
            answer = budgets[budgets.length - 1];
            return answer;
        }

        left = 0;
        while (right>=left) {
            plan = (left+right) / 2;
            int temp = 0;
            int[] tempBud = budgets;
            for (int i=0; i<budgets.length; i++) {
                if (budgets[i] > plan) {
                    temp += plan;
                }
                temp = temp + tempBud[i];
            }

            if (temp > M) right = plan-1;
            else {
                answer = plan;
                left = plan+1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] budgets = {1,1,1};
        int M = 485;

        int answer = solution(budgets, M);

        System.out.println(answer);
    }

}
