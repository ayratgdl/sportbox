package pw.fib.sportbox.numbers;

public class Numbers {
    // greatest common divisor
    public static int gcd(int a, int b) {
        while (true) {
            if (a > b) {
                if (b == 0)
                    return a;
                a = a%b;
            }
            else {
                if (a == 0)
                    return b;
                b = b%a;
            }
        }
    }

    public static long gcd(long a, long b) {
        while (true) {
            if (a > b) {
                if (b == 0)
                    return a;
                a = a%b;
            }
            else {
                if (a == 0)
                    return b;
                b = b%a;
            }
        }
    }

    // least common multiple
    public static int lcm(int a, int b) {
        return a*(b/gcd(a, b));
    }

    public static long lcm(long a, long b) {
        return a*(b/gcd(a, b));
    }
}