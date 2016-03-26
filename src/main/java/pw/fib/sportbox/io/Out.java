package pw.fib.sportbox.io;

/**
 * @author ayratgdl
 * @date 26.03.16
 */
public interface Out {
    Out ln();

    Out write(Object obj);

    Out write(int num);

    Out write(long num);

    Out write(Object[] objs);

    <T> Out write(Iterable<T> iter);

    Out write(int[] nums);

    Out write(long[] nums);
}
