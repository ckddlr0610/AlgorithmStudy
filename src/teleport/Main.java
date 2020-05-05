/**
 * 백준 16958번
 * 문제를 아예 잘못 이해한듯
 * 예제를 반드시 손으로 풀어보고 시작하자
 */

package teleport;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class City {
    boolean isSpecial;
    int x;
    int y;

    City(boolean isSpecial, int x, int y) {
        this.isSpecial = isSpecial;
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static ArrayList<City> citys;
    static int teleportTime;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] string = bufferedReader.readLine().split(" ");
        int cityNum = Integer.parseInt(string[0]);
        teleportTime = Integer.parseInt(string[1]);

        citys = new ArrayList<>();

        for (int i=0; i<cityNum; i++) {
            String[] s = bufferedReader.readLine().split(" ");
            boolean isSpecial = Boolean.getBoolean(s[0]);
            int x = Integer.parseInt(s[1]);
            int y = Integer.parseInt(s[2]);
            City city = new City(isSpecial, x, y);

            citys.add(city);
        }

        int tryNum = Integer.parseInt(bufferedReader.readLine());

        for (int i=0; i<tryNum; i++) {
            String[] dis = bufferedReader.readLine().split(" ");
            int result = getDistance(Integer.parseInt(dis[0]), Integer.parseInt(dis[1]));
            System.out.println(result);
        }
    }

    static int getDistance (int start, int end) {
        if ((citys.get(start - 1).isSpecial == true) && (citys.get(end-1).isSpecial == true)) {
            return teleportTime;
        }

        int x_dis = Math.abs(citys.get(start-1).x - citys.get(end-1).x);
        int y_dis = Math.abs(citys.get(start-1).y - citys.get(end-1).y);
        int time = x_dis + y_dis;

        return time;
    }
}
