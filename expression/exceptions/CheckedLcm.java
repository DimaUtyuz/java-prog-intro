package expression.exceptions;

import expression.BinaryOperation;
import expression.AllExpression;
import expression.MyMath;

public class CheckedLcm extends BinaryOperation {
    public CheckedLcm(AllExpression left, AllExpression right) {
        super(left, right);
    }

    @Override
    public int getPriority() {
        return -1;
    }

    @Override
    public String getSymbol() {
        return "lcm";
    }

    @Override
    public boolean needsBrackets() {
        return true;
    }

    @Override
    public int calculate(int x, int y) {
        if (x == 0 || y == 0) {
            return 0;
        }
        if (x == Integer.MIN_VALUE && y == Integer.MIN_VALUE) {
            throw new CheckOverflow();
        }
        int gcd = MyMath.gcd(x, y);
        CheckOverflow.checkDivide(x, gcd);
        CheckOverflow.checkMultiply(x / gcd, y);
        return x / gcd * y;
    }

    @Override
    public double calculate(double x, double y) {
        throw new UnsupportedOperationException();
    }
}
