package game;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final Game game = new Game(true, new HumanPlayer(), new RandomPlayer());
        int result = -3;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("If you want to play SquareBoard, enter 0");
            System.out.println("If you want to play RhombusBoard, enter 1");
            String str = sc.next();
            if (str.equals("0")) {
                result = game.play(new SquareBoard());
            } else if (str.equals("1")) {
                result = game.play(new RhombusBoard());
            } else {
                System.out.println("Please enter correct Board");
            }
        } while (result != 0);
    }
}
