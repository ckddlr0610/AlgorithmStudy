/**
 * 프로그래머스 서울에서 김서방 찾기
 * 성공했는데 코드를 더 줄일 수 있다 시도해보자
 */

package kimInSeoul;

class Solution {
    public static void main(String[] args){
        String[] seoul = {"Jane","Choe","Kim"};
        String answer = "";

        answer = solution(seoul);
        System.out.println(answer);
    }

    static public String solution(String[] seoul) {
        int location = 0;
        String answer = "";

        for (int i=0; i<seoul.length; i++){
            if (seoul[i].equals("Kim")){
                location = i;
                break;
            }
        }

        String text1 = "김서방은 ";
        String text2 = "에 있다";
        answer = text1 + location + text2;
        return answer;
    }
}
