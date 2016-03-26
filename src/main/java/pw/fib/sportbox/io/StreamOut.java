package pw.fib.sportbox.io;

import java.io.*;

/**
 * @author ayratgdl
 * @date 26.03.16
 */
public class StreamOut implements Out {
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

    @Override
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

    @Override
    public Out write(Object obj) {
        return write(obj.toString());
    }

    @Override
    public Out write(int num) {
        return write(Integer.toString(num));
    }

    @Override
    public Out write(long num) {
        return write(Long.toString(num));
    }

    @Override
    public Out write(Object[] objs) {
        for (Object obj : objs)
            write(obj);
        return this;
    }

    @Override
    public <T> Out write(Iterable<T> iter) {
        for (T obj : iter)
            write(obj);
        return this;
    }

    @Override
    public Out write(int[] nums) {
        for (int num : nums)
            write(num);
        return this;
    }

    @Override
    public Out write(long[] nums) {
        for (long num : nums)
            write(num);
        return this;
    }

    protected Writer getBaseWriter() {
        return writer;
    }
}
