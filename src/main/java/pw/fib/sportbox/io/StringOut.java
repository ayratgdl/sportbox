package pw.fib.sportbox.io;

import java.io.StringWriter;
import java.io.Writer;

/**
 * @author ayratgdl
 * @date 26.03.16
 */
public class StringOut implements Out {
    private StringWriter actual = new StringWriter();
    private StreamOut out = new StreamOut(actual);

    @Override
    public String toString() {
        return actual.toString();
    }

    @Override
    public Out ln() {
        return out.ln();
    }

    @Override
    public Out write(Object obj) {
        return out.write(obj);
    }

    @Override
    public Out write(int num) {
        return out.write(num);
    }

    @Override
    public Out write(long num) {
        return out.write(num);
    }

    @Override
    public Out write(Object[] objs) {
        return out.write(objs);
    }

    @Override
    public <T> Out write(Iterable<T> iter) {
        return out.write(iter);
    }

    @Override
    public Out write(int[] nums) {
        return out.write(nums);
    }

    @Override
    public Out write(long[] nums) {
        return out.write(nums);
    }
}
