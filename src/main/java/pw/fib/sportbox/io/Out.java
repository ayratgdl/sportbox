package pw.fib.sportbox.io;

import java.io.*;

/**
 * @author ayratgdl
 * @date 26.03.16
 */
public class Out {
    private BufferedWriter writer;
    private boolean isEmptyLine = true;

    public Out(BufferedWriter writer) {
        this.writer = writer;
    }

    public Out(Writer writer) {
        this.writer = new BufferedWriter(writer);
    }

    public Out(OutputStream out) {
        this.writer = new BufferedWriter(new OutputStreamWriter(out));
    }

    private Out write(String str) {
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

    public Out ln() {
        try {
            writer.newLine();
            writer.flush();
            isEmptyLine = true;
            return this;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Out write(Object obj) {
        return write(obj.toString());
    }

    public Out write(int num) {
        return write(Integer.toString(num));
    }

    public Out write(long num) {
        return write(Long.toString(num));
    }

    public Out write(Object[] objs) {
        for (Object obj : objs)
            write(obj);
        return this;
    }

    public <T> Out write(Iterable<T> iter) {
        for (T obj : iter)
            write(obj);
        return this;
    }

    public Out write(int[] nums) {
        for (int num : nums)
            write(num);
        return this;
    }

    public Out write(long[] nums) {
        for (long num : nums)
            write(num);
        return this;
    }
}
