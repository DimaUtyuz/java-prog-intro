package expression.exceptions;

import expression.AllExpression;
import expression.MyMath;
import expression.UnaryOperation;

public class CheckedSqrt extends UnaryOperation {
    public CheckedSqrt(AllExpression expression) {
        super(expression);
    }

    @Override
    public int calculate(int x) {
        if (x < 0) {
            throw new MathException("Sqrt is undefined for negative numbers");
        }
        return MyMath.sqrt(x);
    }

    @Override
    public double calculate(double x) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String getSymbol() {
        return "sqrt";
    }
}
