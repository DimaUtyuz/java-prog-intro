package game;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

public class RhombusBoard extends MnkBoard {

    public RhombusBoard() {
        super();
        fillBoard();
    }

    private void fillBoard() {
        for (int i = 0; i < m / 2; i++) {
            for (int j = 0; j < n / 2 - i; j++) {
                cells[j][i] = Cell.B;
                cells[n - j - 1][i] = Cell.B;
                cells[j][m - i - 1] = Cell.B;
                cells[n - j - 1][m - i - 1] = Cell.B;
            }
        }
    }

    @Override
    protected void readSettings() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter length of side, k");
        int nTemp, kTemp;
        while (true) {
            try {
                String s1 = sc.next();
                String s2 = sc.next();
                nTemp = Integer.parseInt(s1);
                kTemp = Integer.parseInt(s2);
                if (nTemp > 0 && 0 < kTemp && kTemp <= 2 * nTemp - 1) {
                    break;
                } else {
                    System.out.println("Please enter correct values: length of side, k - natural numbers, k <= 2 * length - 1");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter correct values: length of side, k - natural numbers, k <= 2 * length - 1");
            }
        }
        m = 2 * nTemp - 1;
        n = 2 * nTemp - 1;
        k = kTemp;
        empty = nTemp * nTemp;
    }
}
