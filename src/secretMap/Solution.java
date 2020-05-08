/**
 * 카카오 2018 블라인드 비밀지도
 * 비트 연산으로 접근하는게 맞는 문제
 * 비트 연산자 OR을 알면 코드를 매우매우매우 간결하게 줄일 수 있다
 */
package secretMap;

import java.text.DecimalFormat;

class Solution {
    public static void main(String[] args) {
        int n = 6;
        int[] arr1 = {46, 33, 33 ,22, 31, 50};
        int[] arr2 = {27 ,56, 19, 14, 14, 10};

        solution(n, arr1, arr2);
    }

    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        String[] deciArr1 = new String[arr1.length];
        String[] deciArr2 = new String[arr2.length];

        StringBuffer deciFormat = new StringBuffer();
        for (int i=0; i<n; i++) {
            deciFormat.append("0");
        }

        //자릿수 맞춰서 2진수로 변환한다
        DecimalFormat decimalFormat = new DecimalFormat(deciFormat.toString());

        for (int i=0; i<arr1.length; i++) {
            String binaryString = Integer.toBinaryString(arr1[i]);
            deciArr1[i] = decimalFormat.format(Integer.parseInt(binaryString));
        }

        for (int i=0; i<arr2.length; i++) {
            String binaryString = Integer.toBinaryString(arr2[i]);
            deciArr2[i] = decimalFormat.format(Integer.parseInt(binaryString));
        }

        String[][] map1 = new String[n][n];
        String[][] map2 = new String[n][n];

        //지도로 변환한다
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (deciArr1[i].charAt(j) == '1' ) {
                    map1[i][j] = "#";
                } else if (deciArr1[i].charAt(j) == '0') {
                    map1[i][j] = " ";
                }
            }
        }

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (deciArr2[i].charAt(j) == '1' ) {
                    map2[i][j] = "#";
                } else if (deciArr2[i].charAt(j) == '0') {
                    map2[i][j] = " ";
                }
            }
        }

        for (int i=0; i<n; i++) {
            StringBuffer temp = new StringBuffer();
            for (int j=0; j<n; j++) {
                if (map1[i][j]==" " && map2[i][j]==" ") {
                    temp.append(" ");
                } else {
                    temp.append("#");
                }
            }
            answer[i] = temp.toString();
        }

        for (int i=0; i<n; i++) {
            System.out.println(answer[i]);
        }

        return answer;
    }
}
