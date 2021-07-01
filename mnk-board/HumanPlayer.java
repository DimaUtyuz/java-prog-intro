package game;

import java.io.PrintStream;
import java.util.Scanner;

public class HumanPlayer implements Player {
    private final PrintStream out;
    private final Scanner in;

    public HumanPlayer(final PrintStream out, final Scanner in) {
        this.out = out;
        this.in = in;
    }

    public HumanPlayer() {
        this(System.out, new Scanner(System.in));
    }

    @Override
    public Move move(final Position position, final Cell cell) {
        while (true) {
            out.println("Position");
            out.println(position);
            out.println(cell + "'s move");
            out.println("Enter row and column");
            int x, y;
            while (true) {
                try {
                    String s1 = in.next();
                    String s2 = in.next();
                    y = Integer.parseInt(s1);
                    x = Integer.parseInt(s2);
                    break;
                } catch (NumberFormatException e) {
                    out.println("Please enter correct values: x and y - coordinates of the Board");
                }
            }
            final Move move = new Move(y - 1, x - 1, cell);
            if (position.isValid(move)) {
                return move;
            }
            out.println("Move " + move + " is invalid");
        }
    }
}
