/**
 * IDE에서 정상적으로 출력 되는 것 같은데
 * 제출하면 틀린 것으로 나온다.
 * 뭐가 문제인지 모르겠으나 다른 사람 풀이를 봤을 때
 * byte를 쓸 필요가 없는 듯
 */

package caesarcipher;

class Solution {
    public static void main(String[] args){
        String s = "d c e R Z Z";
        String answer = solution(s, 25);
        System.out.println(answer);
    }
    public static String solution(String s, int n) {
        String answer = "";
        byte[] bytesArray = s.getBytes();

        for (int i=0; i<bytesArray.length; i++){
            byte byteCode = (byte)s.charAt(i);
            if (byteCode>=65 && byteCode<=90 && byteCode+n>90){
                byteCode = (byte) (((byteCode+n)%90) + 64);
            } else if (byteCode>=97 && byteCode<=122 && byteCode+n>122){
                byteCode = (byte) (((byteCode+n)%122) + 96);
            } else if (byteCode == 32){
                byteCode = 32;
            } else {
                byteCode += n;
            }
            bytesArray[i] = byteCode;
        }

        answer = new String(bytesArray);
        return answer;
    }
}
