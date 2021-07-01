package expression.exceptions;

import expression.BinaryOperation;
import expression.AllExpression;

public class CheckedMultiply extends BinaryOperation {
    public CheckedMultiply(AllExpression left, AllExpression right) {
        super(left, right);
    }

    @Override
    public int getPriority() {
        return 1;
    }

    @Override
    public String getSymbol() {
        return "*";
    }

    @Override
    public boolean needsBrackets() {
        return false;
    }

    @Override
    public int calculate(int x, int y) {
        if (x == 0 || y == 0) {
            return 0;
        }
        CheckOverflow.checkMultiply(x, y);
        return x * y;
    }

    @Override
    public double calculate(double x, double y) {
        throw new UnsupportedOperationException();
    }
}

