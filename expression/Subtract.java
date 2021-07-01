package expression;

public class Subtract extends BinaryOperation {
    public Subtract(AllExpression left, AllExpression right) {
        super(left, right);
    }

    @Override
    public int getPriority() {
        return 0;
    }

    @Override
    public String getSymbol() {
        return "-";
    }

    @Override
    public boolean needsBrackets() {
        return true;
    }

    @Override
    public int calculate(int x, int y) {
        return x - y;
    }

    @Override
    public double calculate(double x, double y) {
        return x - y;
    }
}
