package expression.exceptions;

import expression.AllExpression;
import expression.UnaryOperation;

public class CheckedNegate extends UnaryOperation {
    public CheckedNegate (AllExpression expression) {
        super(expression);
    }
    @Override
    public int calculate(int y) {
        CheckOverflow.checkSubtract(0, y);
        return -y;
    }

    @Override
    public double calculate(double x) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String getSymbol() {
        return "-";
    }
}
