package game;

public class Game {
    private final boolean log;
    private final Player[] players = new Player[2];

    public Game(final boolean log, final Player player1, final Player player2) {
        this.log = log;
        this.players[0] = player1;
        this.players[1] = player2;
    }

    public int play(Board board) {
        int result = 0;
        boolean stop = false;
        while (!stop) {
            for (int i = 0; i < 2 && !stop; i++) {
                while (true) {
                    result = move(board, players[i], i + 1);
                    if (result >= 0) {
                        stop = true;
                        break;
                    } else if (result == -1) {
                        break;
                    }
                }
            }
        }
        if (log) {
            System.out.println("Final position");
            System.out.println(board.getPosition());
            if (result == 0) {
                System.out.println("Game result: draw");
            } else {
                System.out.println("Game result: player " + result + " won");
            }
        }
        return result;
    }

    private int move(final Board board, final Player player, final int no) {
        final Move move = player.move(board.getPosition(), board.getCell());
        final Result result = board.makeMove(move);
        log("Player " + no + " move: " + move);
        log("Position:\n" + board.getPosition());
        if (result == Result.WIN) {
            log("Player " + no + " won");
            return no;
        } else if (result == Result.LOSE) {
            log("Player " + no + " lose");
            return 3 - no;
        } else if (result == Result.DRAW) {
            log("Draw");
            return 0;
        } else if (result == Result.REPEAT) {
            log("One more turn");
            return -2;
        } else {
            return -1;
        }
    }

    private void log(final String message) {
        if (log) {
            System.out.println(message);
        }
    }
}
