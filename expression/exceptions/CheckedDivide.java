package expression.exceptions;

import expression.BinaryOperation;
import expression.AllExpression;

public class CheckedDivide extends BinaryOperation {
    public CheckedDivide(AllExpression left, AllExpression right) {
        super(left, right);
    }

    @Override
    public int getPriority() {
        return 1;
    }

    @Override
    public String getSymbol() {
        return "/";
    }

    @Override
    public boolean needsBrackets() {
        return true;
    }

    @Override
    public int calculate(int x, int y) {
        CheckOverflow.checkDivide(x, y);
        if (y == 0) {
            throw new MathException("divide by zero exception");
        }
        return x / y;
    }

    @Override
    public double calculate(double x, double y) {
        throw new UnsupportedOperationException();
    }
}

