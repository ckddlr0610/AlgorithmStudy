package steppingBridge;

class Solution {
    public static void main(String[] args) {
        int[] stones = {2, 4, 5, 3, 2, 1, 3, 2, 1, 4};
        int k = 9;

        int result = solution(stones, k);

        System.out.println(result);
    }

    public static int solution(int[] stones, int k) {
        int answer = 0;

        int min = 0;

        for (int i=0; i<stones.length-(k-1); i++) {
            int max = stones[i];
            for (int j=i; j<i+k; j++) {
                if (max<stones[j]) max=stones[j];
            }
            if (min==0) {
                min = max;
            } else {
                if (min > max) {
                    min = max;
                }
            }
        }

        answer = min;

        return answer;
    }
}
