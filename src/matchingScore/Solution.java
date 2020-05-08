package matchingScore;

import java.util.ArrayList;

class Solution {
    public static void main(String[] args){
        String word = "Hi";
        String[] pages = {"Hi, <body>Hi,Hi,Hi</body>"};
        solution(word, pages);
    }

    public static int solution(String word, String[] pages) {
        int answer = 0;
        //대문자 소문자 구별을 안하므로 소문자로만 탐색합니다.
        word.toLowerCase();

        ArrayList<Integer> baseScore = new ArrayList<>();

        for (int i=0; i<pages.length; i++) {
            //본문 문자열 자르기
            int temp = pages[i].indexOf("body");
            int left = pages[i].indexOf(">",temp);
            temp = pages[i].indexOf("body", left);
            int right = temp-1;
            String content = pages[i].substring(left,right);
            content.toLowerCase();

            int baseScoreTemp = 0;
            for (int j=0; j<content.length(); j++) {
                int cnt = 0;
                if (word.charAt(0)==content.charAt(j)) {
                    //단어 앞 뒤로 문자가 아닌지 확인
                    if (content.charAt(j-1)>='a' && content.charAt(j-1)<'{') {
                        continue;
                    }
                    if (content.charAt(j+word.length())>='a' && content.charAt(j+word.length())<'{') {
                        continue;
                    }

                    for (int z=0; z<word.length(); z++) {
                        if (word.charAt(z) == content.charAt(j+z)) {
                            cnt++;
                        }
                    }
                }
                if (cnt == word.length()) {
                    baseScoreTemp++;
                }
            }

            if (baseScoreTemp!=0) {
                baseScore.add(baseScoreTemp);
            }

        }

        answer = baseScore.get(0);

        return answer;
    }
}
