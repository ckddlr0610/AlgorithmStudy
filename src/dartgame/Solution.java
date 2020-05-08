package dartgame;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {
    public int solution(String dartResult) {
        int answer = 0;

        Pattern pattern = Pattern.compile("(^[0-10]*$)");
        Matcher matcher = pattern.matcher(dartResult);
        String temp = dartResult.substring(matcher.start(),matcher.end());

        return answer;
    }
}
