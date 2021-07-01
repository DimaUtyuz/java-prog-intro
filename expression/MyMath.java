package expression;

public class MyMath {
    public static int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return abs(a);
    }

    public static int abs(int x) {
        return x > 0 ? x: -x;
    }

    public static int sqrt(int x) {
        return (int) Math.sqrt(x);
    }

    public static int sign(int x) {
        if (x > 0) {
            return 1;
        } else if (x == 0) {
            return 0;
        } else {
            return -1;
        }
    }

    public static int max(int a, int b) {
        return a > b ? a: b;
    }

    public static int min(int a, int b) {
        return a < b ? a: b;
    }
}
