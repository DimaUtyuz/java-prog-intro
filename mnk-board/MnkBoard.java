package game;

import java.io.IOException;
import java.util.*;

public class MnkBoard implements Board {
    private static final Map<Cell, Character> SYMBOLS = Map.of(
            Cell.X, 'X',
            Cell.O, 'O',
            Cell.E, '.',
            Cell.B, ' '
    );

    protected final Cell[][] cells;
    private Cell turn;
    protected int m, n, k, empty;
    private final int nLength, mLength;
    private final String nSpaces, mSpaces;
    private final Position position = new Position() {
        @Override
        public boolean isValid(final Move move) {
            return 0 <= move.getRow() && move.getRow() < getN()
                    && 0 <= move.getColumn() && move.getColumn() < getM()
                    && cells[move.getRow()][move.getColumn()] == Cell.E
                    && turn == move.getValue();
        }

        @Override
        public Cell getCell(final int r, final int c) {
            return cells[r][c];
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder(nSpaces);
            for (int c = 1; c <= m; c++) {
                sb.append(" ".repeat(mLength + 1 - Integer.toString(c).length())).append(c);
            }
            for (int r = 0; r < n; r++) {
                sb.append("\n");
                sb.append(" ".repeat(nLength - Integer.toString(r + 1).length())).append(r + 1);
                for (int c = 0; c < m; c++) {
                    sb.append(mSpaces).append(SYMBOLS.get(cells[r][c]));
                }
            }
            return sb.toString();
        }

        @Override
        public int getN() {
            return n;
        }

        @Override
        public int getM() {
            return m;
        }
    };

    public MnkBoard() {
        readSettings();
        nLength = Integer.toString(n).length();
        mLength = Integer.toString(m).length();
        nSpaces = " ".repeat(nLength);
        mSpaces = " ".repeat(mLength);
        this.cells = new Cell[n][m];
        for (Cell[] row : cells) {
            Arrays.fill(row, Cell.E);
        }
        turn = Cell.X;
    }

    @Override
    public final Position getPosition() {
        return position;
    }

    @Override
    public Cell getCell() {
        return turn;
    }

    @Override
    public Result makeMove(final Move move) {
        if (!position.isValid(move)) {
            return Result.LOSE;
        }
        cells[move.getRow()][move.getColumn()] = move.getValue();
        empty--;
        int x = move.getColumn();
        int y = move.getRow();
        int max = 0;
        if (count(x, y, 0, 1) + count(x, y, 0, -1) + 1 > max) {
            max = count(x, y, 0, 1) + count(x, y, 0, -1) + 1;
        }
        if (count(x, y, 1, 0) + count(x, y, -1, 0)  + 1 > max) {
            max = count(x, y, 1, 0) + count(x, y, -1, 0) + 1;
        }
        if (count(x, y, 1, 1) + count(x, y, -1, -1) + 1 > max) {
            max = count(x, y, 1, 1) + count(x, y, -1, -1) + 1;
        }
        if (count(x, y, 1, -1) + count(x, y, -1, 1) + 1 > max) {
            max = count(x, y, 1, -1) + count(x, y, -1, 1) + 1;
        }
        if (max >= k) {
            return Result.WIN;
        }
        if (empty == 0) {
            return Result.DRAW;
        }
        if (max >= 4) {
            return Result.REPEAT;
        } else {
            turn = turn == Cell.X ? Cell.O : Cell.X;
        }
        return Result.UNKNOWN;
    }

    private int count(int x, int y, int dx, int dy) {
        int ans = 0;
        while (0 <= x + dx && x + dx < m
                && 0 <= y + dy && y + dy < n
                && cells[y + dy][x + dx] == turn) {
            ans++;
            x += dx;
            y += dy;
        }
        return ans;
    }

    protected void readSettings() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter width, height, k");
        int mTemp, nTemp, kTemp;
        while (true) {
            try {
                String s1 = sc.next();
                String s2 = sc.next();
                String s3 = sc.next();
                mTemp = Integer.parseInt(s1);
                nTemp = Integer.parseInt(s2);
                kTemp = Integer.parseInt(s3);
                if (nTemp > 0 && mTemp > 0 && 0 < kTemp && (kTemp <= mTemp || kTemp <= nTemp)) {
                    break;
                } else {
                    System.out.println("Please enter correct values: width, height, k - natural numbers, k <= max(width, height)");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter correct values: length of side, k - natural numbers, k <= max(width, height");
            }
        }
        m = mTemp;
        n = nTemp;
        k = kTemp;
        empty = n * m;
    }
}
