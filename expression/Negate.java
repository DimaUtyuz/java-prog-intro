package expression;

public class Negate extends UnaryOperation {
    public Negate(AllExpression expression) {
        super(expression);
    }

    @Override
    public int calculate(int x) {
        return -x;
    }

    @Override
    public double calculate(double x) {
        return -x;
    }

    @Override
    public String getSymbol() {
        return "-";
    }
}
