package expression;

public class And extends BinaryOperation {
    public And(AllExpression left, AllExpression right) {
        super(left, right);
    }

    @Override
    public int getPriority() {
        return -1;
    }

    @Override
    public String getSymbol() {
        return "&";
    }

    @Override
    public boolean needsBrackets() {
        return false;
    }

    @Override
    public int calculate(int x, int y) {
        return x & y;
    }

    @Override
    public double calculate(double x, double y) {
        throw new UnsupportedOperationException();
    }
}
