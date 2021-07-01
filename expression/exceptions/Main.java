package expression.exceptions;

import expression.AllExpression;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            AllExpression expression = new ExpressionParser().parse(sc.nextLine());
            for (int i = 0; i < 11; i++) {
                try {
                    int result = expression.evaluate(i);
                    System.out.println(result);
                } catch (MathException e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
    }
}
