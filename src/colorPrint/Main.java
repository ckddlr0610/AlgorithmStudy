/**
 * 백준 2630번 색종이 문제
 * 분할 정복을 어떻게 접근할 지에 대해서 잘 알아두기
 */

package colorPrint;

import java.io.*;

public class Main {
    static String[][] strings;
    static int white = 0;
    static int blue = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = Integer.parseInt(reader.readLine());
        strings = new String[size][size];
        for (int x=0; x<size; x++){
            String[] lines = reader.readLine().split(" ");
            for (int y=0; y<size; y++) {
                strings[x][y] = lines[y];
            }
        }

        divide(0,0, size);

        writer.write(white+"\n"+blue);
        writer.flush();
        writer.close();
    }

    static void divide(int x, int y, int size){
        // 1이면 blue, 2이면 white
        String color = strings[x][y];
        boolean sameColor = false;
        if (size == 1) {
            if (strings[x][y].equals("1")) {
                blue++;
            } else {
                white++;
            }
            return;
        }

        for (int dx = x; dx < size; dx++) {
            for (int dy = y; dy < size; dy++) {
                if (!strings[dx][dy].equals(color)) {
                    sameColor = false;
                    break;
                }
            }
        }

        if (sameColor) {
            if (color.equals("1")) {
                blue++;
            } else {
                white++;
            }
        }

        size = size/2;
        divide(x, y, size);
        divide(size, y, size);
        divide(x, size, size);
        divide(size, size, size);
    }
}

/**
 * 2차원 배열을 탐색하는데 같은 색인지 다른 색인지 판단해야함
 * 문제를 계속 나눠서 생각해야하므로 분할 정복으로 접근할 수 있음
 * 예를 들면 전체 배열에서 4등분해서 각각을 해결하는 형식임
 *
 * 만약 사이즈가 1이면 최저로 나눈 것이므로 색 판단후 바로 점수를 올린다
 * 할당받은 배열을 탐색하다가 같은 색인지 다른 색인지 판단하고
 * 같은 색이면 점수 올리고 탐색을 종료한다.
 * 다른 색이면 분할해야한다.
 */
