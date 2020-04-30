/**
 * 백준 1027번 문제
 * 기울기 구하는 부분이 잘 안되는듯
 */

package Skyline;

import java.io.*;
import java.util.Scanner;

public class Main {
    static int num_tower;
    static int[] height;
    static int[] count;
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        num_tower = scanner.nextInt();
        height = new int[num_tower];
        count = new int[num_tower];


        for (int i=0; i<num_tower; i++) {
            height[i] = scanner.nextInt();
        }

        for (int j=0; j<num_tower; j++) {
            checkLook(j);
        }

        for (int z=0; z<num_tower; z++){
            System.out.println(count[z]);
        }
    }

    static void checkLook(int mTower) {
        boolean isLook = false;

        for (int i=0; i<num_tower; i++){
            isLook = true;
            if (i==mTower) continue;
            if (i==mTower-1 || i==mTower+1) {
                count[mTower]++;
                continue;
            }
            if (i<mTower) {
                for (int j=i+1; j<mTower; j++) {
                    int lookLine = height[mTower]+(((height[i] - height[mTower])/Math.abs(mTower-i))*Math.abs(j-mTower));
                    if (height[j]>=lookLine) {
                        isLook = false;
                        break;
                    }
                }
            }
            if (i>mTower) {
                for (int j=mTower+1; j<i; j++) {
                    int lookLine = height[mTower]+(((height[i] - height[mTower])/Math.abs(mTower-i))*Math.abs(j-mTower));
                    if (height[j]>=lookLine) {
                        isLook = false;
                        break;
                    }
                }
            }
            if (isLook) {
                count[mTower]++;
            }
        }
    }
}
