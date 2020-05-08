package targetNumber;

class Solution {
    static int[] numbers;
    static int target;
    static int answer = 0;
    public static void main(String[] args) {
        numbers = new int[]{1, 1, 1, 1, 1};
        target = 3;

        int result = solution(numbers,target);
        System.out.println(result);
    }

    public static int solution(int[] numbers, int target) {

        //this.numbers = numbers;
        //this.target= target;

        dfs(0, 0, true);
        dfs(0, 0, false);

        return answer;
    }

    public static void dfs(int index, int sum, boolean isPositive) {
        int temp = numbers[index];
        if (isPositive) {
            sum += temp;
        } else {
            sum -= temp;
        }

        if (index == numbers.length-1) {
            if (sum == target) {
                answer++;
            }
            return;
        }

        dfs(index+1, sum, true);
        dfs(index+1, sum, false);

    }
}
