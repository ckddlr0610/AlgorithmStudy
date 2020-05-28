package morebignumber;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public static void main(String[] args) {
        int[] numbers = {0, 0, 0, 0};

        String answer = solution(numbers);

        System.out.println(answer);
    }

    public static String solution(int[] numbers) {
        String answer = "";

        String[] stringnum = new String[numbers.length];

        for (int i=0; i<numbers.length; i++) {
            stringnum[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(stringnum, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (Integer.parseInt(o2+o1) > Integer.parseInt(o1+o2)) {
                    return 1;
                } else if (Integer.parseInt(o2+o1) < Integer.parseInt(o1+o2)) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });

        if (stringnum[0].equals("0")) {
            return "0";
        }

        for (int i=0; i<stringnum.length; i++) {
            answer += stringnum[i];
        }

        return answer;
    }
}
