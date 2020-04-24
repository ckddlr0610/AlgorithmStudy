/**
 * 숭실대학교 영약 문제
 * 틀림
 */

package drugSoongsil;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int[][] drug = new int[2][];
        int[] dzArray = new int[100];
        int num;
        int dNum;
        int name;
        int effect;
        int dzNum;
        int dzEffect;

        num = Integer.parseInt(scanner.next());

        for (int i=0; i<num; i++){
            effect = Integer.parseInt(scanner.next());
            name = Integer.parseInt(scanner.next());
            drug[0][i] = effect;
            drug[1][i] = name;
        }

        dNum = Integer.parseInt(scanner.next());

        for (int i=0; i<dNum; i++){
            dzNum = Integer.parseInt(scanner.next());
            for (int j=0; j<dzNum; j++){
                dzEffect = Integer.parseInt(scanner.next());
                for (int z=0; z<num; z++){
                    if (drug[0][z] == dzEffect){
                        System.out.print(drug[1][z]);
                    }
                }
                dzArray[j] = dzEffect;
            }
        }
    }
}
