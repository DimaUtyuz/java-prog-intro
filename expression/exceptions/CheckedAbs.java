package expression.exceptions;

import expression.AllExpression;
import expression.MyMath;
import expression.UnaryOperation;

public class CheckedAbs extends UnaryOperation {
    public CheckedAbs(AllExpression expression) {
        super(expression);
    }

    @Override
    public int calculate(int x) {
        if (x < 0) {
            CheckOverflow.checkMultiply(x, -1);
        }
        return MyMath.abs(x);
    }

    @Override
    public double calculate(double x) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String getSymbol() {
        return "abs";
    }
}
