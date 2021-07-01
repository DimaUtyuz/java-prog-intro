package expression.exceptions;

import expression.BinaryOperation;
import expression.AllExpression;

public class CheckedAdd extends BinaryOperation {
    public CheckedAdd(AllExpression left, AllExpression right) {
        super(left, right);
    }

    @Override
    public int getPriority() {
        return 0;
    }

    @Override
    public String getSymbol() {
        return "+";
    }

    @Override
    public boolean needsBrackets() {
        return false;
    }

    @Override
    public int calculate(int x, int y) {
        CheckOverflow.checkAdd(x, y);
        return x + y;
    }

    @Override
    public double calculate(double x, double y) {
        throw new UnsupportedOperationException();
    }
}

