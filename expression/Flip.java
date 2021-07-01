package expression;

public class Flip extends UnaryOperation {
    public Flip(AllExpression expression) {
        super(expression);
    }

    @Override
    public int calculate(int x) {
        long ans = Integer.toUnsignedLong(Integer.reverse(x));
        return ans != 0 ? (int) (ans / Long.lowestOneBit(ans)) : 0;
    }

    @Override
    public double calculate(double x) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String getSymbol() {
        return "flip";
    }
}
