package ironStick;

import java.util.Scanner;
import java.util.Stack;

class Solution {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int times = scanner.nextInt();
        int result=0;
        Stack<Character> sticks = new Stack();

        for (int i=0; i<times; i++) {
            String string = scanner.next();

            for (int j=1; j<string.length(); j++) {
                if (string.charAt(j-1)=='(' && string.charAt(j)==')') {
                    result += sticks.size();
                } else if (string.charAt(j)=='(' && string.charAt(j+1)==')') {
                    sticks.push(string.charAt(j));
                } else if (string.charAt(j)==')') {
                    sticks.pop();
                    result++;
                }
            }
            System.out.println("#"+(i+1)+" "+ result);
        }
    }
}
