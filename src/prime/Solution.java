package prime;

class Solution {
    static int answer;
    public static void main(String[] args) {
        String numbers = "17";
        int arg = solution(numbers);
        System.out.println(arg);
    }

    public static int solution(String numbers) {
        answer = 0;

        String[] strings = numbers.split("");
        boolean[] visited = new boolean[strings.length];
        String[] output = new String[strings.length];

        isPrimeNumber(strings, visited, output, 0);

        return answer;
    }

    static void isPrimeNumber(String[] strings, boolean[] visited, String[] output, int idx) {
        if (idx==strings.length) {
            StringBuffer stringBuffer = new StringBuffer();
            for (int i=0; i<output.length; i++) {
                stringBuffer.append(output[i]);
            }
            String tempStr = stringBuffer.toString();

            int temp = Integer.parseInt(tempStr);

            if (temp == 1) {
                return;
            }

            if (temp == 2) {
                answer++;
                return;
            }

            if (temp != 2 && temp%2 == 0) {
                return;
            }

            for (int i=3; i<temp; i=i+2) {
                if (temp%i == 0) {
                    return;
                }
            }
            answer++;
            return;
        }

        for (int i=idx; i<strings.length; i++) {
            if (visited[idx] != true){
                visited[idx] = true;
                output[idx] = strings[idx];
                isPrimeNumber(strings, visited, output, idx+1);
                visited[idx] = false;
                output[idx] = "0";
                isPrimeNumber(strings, visited, output,  idx+1);
            }

        }
    }
}
