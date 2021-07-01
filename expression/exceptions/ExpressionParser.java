package expression.exceptions;

import expression.*;
import expression.parser.BaseParser;
import expression.parser.StringSource;

import java.util.List;

public class ExpressionParser extends BaseParser implements Parser {
    private static final List<List <String>> levels = List.of(
        List.of("*", "/"),
        List.of("+", "-"),
        List.of("gcd", "lcm")
    );

    @Override
    public AllExpression parse(String expression) throws ParseException {
        setSource(new StringSource(expression));
        AllExpression result = parse(levels.size() - 1);
        if (ch != END) {
            throw new ExtraneousCharactersException(getPosition(), getStr());
        }
        return result;
    }

    private AllExpression parse(int level) throws ParseException {
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

    private AllExpression parseUnExpression() throws ParseException, VariableNotFoundException {
        skipWhitespace();
        if (isDigit()) {
            return parseConst(false);
        } else if (test('-')) {
            skipWhitespace();
            if (isDigit()) {
                return parseConst(true);
            } else {
                return new CheckedNegate(parseUnExpression());
            }
        } else if (test("abs")) {
            return new CheckedAbs(parseUnExpression());
        } else if (test("sqrt")) {
            return new CheckedSqrt(parseUnExpression());
        } else if (test('(')) {
            AllExpression result = parse(levels.size() - 1);
            if (!test(')')) {
                throw new ParenthesisNotFoundException(ch, getPosition(), getStr());
            }
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
                default: throw new VariableNotFoundException(result, getPosition(), getStr());
            }
        }
    }

    private Const parseConst(boolean flag) throws ParseException {
        StringBuilder sb = new StringBuilder();
        if (flag) {
            sb.append("-");
        }
        while (isDigit()) {
            sb.append(ch);
            nextChar();
        }
        String result = sb.toString();
        try {
            return new Const(Integer.parseInt(result));
        } catch (NumberFormatException e) {
            throw new NumberNotFoundException("The number \"" + result + "\" doesn't exist", getPosition(), getStr());
        }
    }

    private BinaryOperation parseBinExpression(String operation, AllExpression left, AllExpression right) throws ParseException {
        switch (operation) {
            case "gcd": return new CheckedGcd(left, right);
            case "lcm": return new CheckedLcm(left, right);
            case "+": return new CheckedAdd(left, right);
            case "-": return new CheckedSubtract(left, right);
            case "*": return new CheckedMultiply(left, right);
            case "/": return new CheckedDivide(left, right);
            default: throw new OperationNotFoundException("The operation \"" + operation + "\" doesn't exist", getPosition(), getStr());
        }
    }
}
