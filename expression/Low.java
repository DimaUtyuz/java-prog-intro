package expression;

public class Low extends UnaryOperation {
    public Low(AllExpression expression) {
        super(expression);
    }

    @Override
    public int calculate(int x) {
        return Integer.lowestOneBit(x);
    }

    @Override
    public double calculate(double x) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String getSymbol() {
        return "low";
    }
}
