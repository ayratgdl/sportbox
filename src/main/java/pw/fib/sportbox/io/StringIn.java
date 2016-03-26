package pw.fib.sportbox.io;

import java.io.StringReader;

/**
 * @author ayratgdl
 * @date 26.03.16
 */
public class StringIn implements In {
    private StringBuilder buffer = new StringBuilder();
    private StreamIn in;

    public StringIn append(String str) {
        buffer.append(str);
        return this;
    }

    public StringIn appendLn(String str) {
        buffer.append(str).append("\n");
        return this;
    }

    @Override
    public String word() {
        return getIn().word();
    }

    @Override
    public int int1() {
        return getIn().int1();
    }

    @Override
    public long long1() {
        return getIn().long1();
    }

    @Override
    public String[] words(int n) {
        return getIn().words(n);
    }

    @Override
    public int[] ints(int n) {
        return getIn().ints(n);
    }

    @Override
    public long[] longs(int n) {
        return getIn().longs(n);
    }

    private StreamIn getIn() {
        if (in == null) {
            in = new StreamIn(new StringReader(buffer.toString()));
        }
        return in;
    }
}
