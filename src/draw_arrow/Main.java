package draw_arrow;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int num;
        List<ArrowDot> dotList;
        Scanner scanner = new Scanner(System.in);

        num = scanner.nextInt();
        dotList = new ArrayList<>(num);

        for (int i=0; i<num; i++) {
            int cor = 0;
            int color = 0;
            for (int j=0; j<2; j++) {
                cor = scanner.nextInt();
                color = scanner.nextInt();
            }
            dotList.add(new ArrowDot(cor,color));
        }


    }

    static class ArrowDot {
        int cor;
        int color;

        public ArrowDot(int cor, int color) {
            this.cor = cor;
            this.color = color;
        }

        public int getCor() {
            return cor;
        }

        public int getColor() {
            return color;
        }
    }
}
