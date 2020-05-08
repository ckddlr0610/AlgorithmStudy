package tuple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class Solution {
    public int[] solution(String s) {
        int[] answer = {};

        s.substring(2, s.length()-2);

        StringTokenizer tokenizer = new StringTokenizer(s, "},{");
        String[] strings = new String[tokenizer.countTokens()];
        answer = new int[tokenizer.countTokens()];

        for (int i=0; i<tokenizer.countTokens(); i++) {
            strings[i] = tokenizer.nextToken();
        }

        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length()-o2.length();
            }
        });

        ArrayList<Integer> list = new ArrayList<>();

        for (int j=0; j<strings.length; j++) {
            String[] temp = strings[j].split(",");

            for (int k=0; k<temp.length; k++) {
                int tempInt = Integer.parseInt(temp[k]);

                if (!list.contains(tempInt)) {
                    list.add(tempInt);
                }
            }
        }

        for (int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
