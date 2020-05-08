package parentheses;

import java.util.Stack;

class Solution {
    public String solution(String p) {
        String answer = "";

        return answer;
    }
/*
    public static String transform(String p) {
        int leftcnt=0;
        int rightcnt=0;
        String u_str = "";
        String v_str = "";
        Stack<Character> stack = new Stack<>();

        for (int i=0; i<p.length(); i++) {
            if (p.charAt(i)=='(') {
                leftcnt++;
            } else {
                rightcnt++;
            }
            if (leftcnt==rightcnt) {
                u_str = p.substring(0, i+1);
                v_str = p.substring(i+1);
            }
        }

        for (int i=0; i<u_str.length(); i++) {
            if (u_str.charAt(i)=='(') {
                stack.push(u_str.charAt(i));
            } else {
                //stack.pop()
            }
        }
    }*/
}
