/**
 * 백준 18222번 투에-모스 수열
 * 답은 제대로 나오는데 어디서 문제가 있는건지 런타임 에러 발생
 */

package thusMorse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int k;
    static boolean answer;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(bufferedReader.readLine());

        boolean[] strings = {false};
        search(strings);
        if (answer) {
            System.out.println("1");
        } else if (answer==false) {
            System.out.println("0");
        }

    }

    public static void search(boolean[] strings){
        if (strings.length > k) {
            answer = strings[k-1];
            return;
        }

        boolean[] temp = new boolean[strings.length];
        for (int i=0; i<strings.length; i++) {
            if (strings[i] == true) {
                temp[i] = false;
            } else {
                temp[i] = true;
            }
        }

        boolean[] nextString = new boolean[strings.length*2];

        for (int j=0; j<strings.length; j++) {
            nextString[j] = strings[j];
        }
        for (int z=0; z<strings.length; z++) {
            nextString[z+strings.length] = temp[z];
        }

        search(nextString);
    }
}
