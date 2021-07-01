package expression;

public class Divide extends BinaryOperation {
    public Divide(AllExpression left, AllExpression right) {
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
        return x / y;
    }

    @Override
    public double calculate(double x, double y) {
        return x / y;
    }
}
