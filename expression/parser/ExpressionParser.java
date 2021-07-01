package expression.parser;

import expression.*;

import java.util.List;

public class ExpressionParser extends BaseParser implements Parser {
    private static final List<List <String>> levels = List.of(
        List.of("*", "/"),
        List.of("+", "-"),
        List.of("gcd", "lcm")
    );

    @Override
    public AllExpression parse(String expression) {
        setSource(new StringSource(expression));
        return parse(levels.size() - 1);
    }

    private AllExpression parse(int level) {
        if (level == -1) {
            return parseUnExpression();
        }
        skipWhitespace();
        AllExpression result = parse(level - 1);
        boolean flag = true;
        while (flag) {
            flag = false;
            skipWhitespace();
            for (String operation : levels.get(level)) {
                if (test(operation)) {
                    result = parseBinExpression(operation, result, parse(level - 1));
                    flag = true;
                }
            }
        }
        return result;
    }

    private AllExpression parseUnExpression() {
        skipWhitespace();
        if (isDigit()) {
            return parseConst(false);
        } else if (test('-')) {
            skipWhitespace();
            if (isDigit()) {
                return parseConst(true);
            } else {
                return new Negate(parseUnExpression());
            }
        } else if (test("flip")) {
            return new Flip(parseUnExpression());
        } else if (test("low")) {
            return new Low(parseUnExpression());
        } else if (test('(')) {
            AllExpression result = parse(levels.size() - 1);
            test(')');
            return result;
        } else {
            skipWhitespace();
            StringBuilder sb = new StringBuilder();
            while (isVariable(ch)) {
                sb.append(ch);
                nextChar();
            }
            String result = sb.toString();
            switch (result) {
                case "x": return new Variable(result);
                case "y": return new Variable(result);
                case "z": return new Variable(result);
                default: return null;
            }
        }
    }

    private Const parseConst(boolean flag) {
        StringBuilder sb = new StringBuilder();
        if (flag) {
            sb.append("-");
        }
        while (isDigit()) {
            sb.append(ch);
            nextChar();
        }
        String result = sb.toString();
        return new Const(Integer.parseInt(result));
    }

    private BinaryOperation parseBinExpression(String operation, AllExpression left, AllExpression right) {
        switch (operation) {
            case "&": return new And(left, right);
            case "|": return new Or(left, right);
            case "^": return new Xor(left, right);
            case "+": return new Add(left, right);
            case "-": return new Subtract(left, right);
            case "*": return new Multiply(left, right);
            case "/": return new Divide(left, right);
            default: return null;
        }
    }
}
