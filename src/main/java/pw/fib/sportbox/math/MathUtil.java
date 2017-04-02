package pw.fib.sportbox.math;

/**
 * @author ayratgdl
 * @date 02.04.17
 */
public class MathUtil {
    public static int divUp(int a, int b) {
        int r = a / b;
        if (a % b != 0) {
            r++;
        }
        return r;
    }

    public static long divUp(long a, long b) {
        long r = a / b;
        if (a % b != 0) {
            r++;
        }
        return r;
    }
}
