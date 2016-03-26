package pw.fib.sportbox.io;

/**
 * @author ayratgdl
 * @date 26.03.16
 */
public interface In {
    String word();

    int int1();

    long long1();

    String[] words(int n);

    int[] ints(int n);

    long[] longs(int n);
}
