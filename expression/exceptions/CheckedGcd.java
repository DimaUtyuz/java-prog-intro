package expression.exceptions;

import expression.BinaryOperation;
import expression.AllExpression;
import expression.MyMath;

public class CheckedGcd extends BinaryOperation {
    public CheckedGcd(AllExpression left, AllExpression right) {
        super(left, right);
    }

    @Override
    public int getPriority() {
        return -1;
    }

    @Override
    public String getSymbol() {
        return "gcd";
    }

    @Override
    public boolean needsBrackets() {
        return true;
    }

    @Override
    public int calculate(int x, int y) {
        if (x == Integer.MIN_VALUE && y == Integer.MIN_VALUE) {
            throw new CheckOverflow();
        }
        return MyMath.gcd(x, y);
    }

    @Override
    public double calculate(double x, double y) {
        throw new UnsupportedOperationException();
    }
}
