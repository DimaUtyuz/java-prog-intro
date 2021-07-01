package expression;

import java.util.Objects;

public abstract class BinaryOperation extends AllExpression {
    private final AllExpression left;
    private final AllExpression right;

    public BinaryOperation(AllExpression left, AllExpression right) {
        this.left = left;
        this.right = right;
    }

    public abstract double calculate(double x, double y);
    public abstract int calculate(int x, int y);
    public abstract String getSymbol();
    public abstract int getPriority();
    public abstract boolean needsBrackets();

    @Override
    public double evaluate(double x) {
        return calculate(left.evaluate(x), right.evaluate(x));
    }

    @Override
    public int evaluate(int x) {
        return calculate(left.evaluate(x), right.evaluate(x));
    }

    @Override
    public int evaluate(int x, int y, int z) {
        return calculate(left.evaluate(x, y, z), right.evaluate(x, y, z));
    }

    @Override
    public String toString() {
        return addBrackets(left.toString() + " " + getSymbol() + " " + right.toString(), true);
    }

    @Override
    public String toMiniString() {
        return addBrackets(left.toMiniString(), checkPriorityBrackets(left)) +
                " " + getSymbol() + " " +
                addBrackets(right.toMiniString(), checkPriorityBrackets(right) || checkNeedsBrackets(right));
    }

    private boolean checkPriorityBrackets(AllExpression expression) {
        if (expression instanceof BinaryOperation) {
            return ((BinaryOperation) expression).getPriority() < getPriority();
        } else {
            return false;
        }
    }

    private boolean checkNeedsBrackets(AllExpression expression) {
        if (expression instanceof BinaryOperation) {
            BinaryOperation binaryOperation = (BinaryOperation) expression;
            return binaryOperation.getPriority() == getPriority()
                    && (this.needsBrackets()
                        || this.getPriority() == 1 && binaryOperation.needsBrackets());
        } else {
            return false;
        }
    }

    private String addBrackets(String expression, boolean flag) {
        if (flag) {
            return "(" + expression + ")";
        } else {
            return expression;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof BinaryOperation) {
            BinaryOperation binaryOperation = (BinaryOperation) obj;
            return this.getClass() == binaryOperation.getClass()
                    && Objects.equals(left, binaryOperation.left)
                    && Objects.equals(right, binaryOperation.right);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right, getClass());
    }
}
