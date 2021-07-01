package expression;

public class Xor extends BinaryOperation {
    public Xor(AllExpression left, AllExpression right) {
        super(left, right);
    }

    @Override
    public int getPriority() {
        return -2;
    }

    @Override
    public String getSymbol() {
        return "^";
    }

    @Override
    public boolean needsBrackets() {
        return false;
    }

    @Override
    public int calculate(int x, int y) {
        return x ^ y;
    }

    @Override
    public double calculate(double x, double y) {
        throw new UnsupportedOperationException();
    }
}
