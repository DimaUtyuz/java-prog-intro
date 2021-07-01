package expression;

public abstract class UnaryOperation extends AllExpression {
    protected final AllExpression expression;

    public UnaryOperation(AllExpression expression) {
        this.expression = expression;
    }

    public abstract double calculate(double x);
    public abstract int calculate(int x);
    public abstract String getSymbol();

    @Override
    public int evaluate(int x) {
        int value = expression.evaluate(x);
        return calculate(value);
    }

    @Override
    public int evaluate(int x, int y, int z) {
        int value = expression.evaluate(x, y, z);
        return calculate(value);
    }

    @Override
    public double evaluate(double x) {
        double value = expression.evaluate(x);
        return calculate(value);
    }

    @Override
    public String toString() {
        return getSymbol() + "(" + expression.toString() + ")";
    }

    @Override
    public String toMiniString() {
        boolean needBrackets = expression instanceof BinaryOperation;
        return getSymbol() + (needBrackets ? "(" : "")
                + expression.toMiniString() + (needBrackets ? ")" : "");
    }
}
