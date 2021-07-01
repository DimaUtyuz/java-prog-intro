package expression;

import java.util.Objects;

public final class Const extends AllExpression {
    private final Number number;

    public Const(Number number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return number.toString();
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Const && number.equals(((Const) obj).number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public double evaluate(double x) {
        return number.doubleValue();
    }

    @Override
    public int evaluate(int x, int y, int z) {
        return number.intValue();
    }

    @Override
    public int evaluate(int x) {
        return number.intValue();
    }
}
