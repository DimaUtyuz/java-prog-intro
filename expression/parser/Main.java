package expression.parser;

import expression.AllExpression;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AllExpression expression = new ExpressionParser().parse(sc.nextLine());
        System.out.println(expression);
        System.out.println(expression.toMiniString());
        System.out.println(expression.evaluate(2));
    }
}
