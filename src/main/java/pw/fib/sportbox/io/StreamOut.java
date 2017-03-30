package pw.fib.sportbox.io;

import java.io.*;

/**
 * @author ayratgdl
 * @date 26.03.16
 */
public class StreamOut {
    private BufferedWriter writer;
    private boolean isEmptyLine = true;

    public StreamOut(BufferedWriter writer) {
        this.writer = writer;
    }

    public StreamOut(Writer writer) {
        this.writer = new BufferedWriter(writer);
    }

    public StreamOut(OutputStream out) {
        this.writer = new BufferedWriter(new OutputStreamWriter(out));
    }

    private StreamOut write(String str) {
        try {
            if (!isEmptyLine)
                writer.write(" ");
            else
                isEmptyLine = false;
            writer.write(str);
            return this;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public StreamOut ln() {
        try {
            writer.newLine();
            writer.flush();
            isEmptyLine = true;
            return this;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public StreamOut write(Object obj) {
        return write(obj.toString());
    }

    public StreamOut write(int num) {
        return write(Integer.toString(num));
    }

    public StreamOut write(long num) {
        return write(Long.toString(num));
    }

    public StreamOut write(Object[] objs) {
        for (Object obj : objs)
            write(obj);
        return this;
    }

    public <T> StreamOut write(Iterable<T> iter) {
        for (T obj : iter)
            write(obj);
        return this;
    }

    public StreamOut write(int[] nums) {
        for (int num : nums)
            write(num);
        return this;
    }

    public StreamOut write(long[] nums) {
        for (long num : nums)
            write(num);
        return this;
    }
}
