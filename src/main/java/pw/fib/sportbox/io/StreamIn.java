package pw.fib.sportbox.io;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author ayratgdl
 * @date 26.03.16
 */
public class StreamIn implements In {
    private BufferedReader reader;
    StringTokenizer tokener;

    public StreamIn(BufferedReader reader) {
        this.reader = reader;
    }

    public StreamIn(Reader reader) {
        this.reader = new BufferedReader(reader);
    }

    public StreamIn(InputStream in) {
        reader = new BufferedReader(new InputStreamReader(in));
    }

    @Override
    public String word() {
        try {
            if (tokener == null || !tokener.hasMoreTokens())
                tokener = new StringTokenizer(reader.readLine());
            return tokener.nextToken();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int int1() {
        return Integer.parseInt(word());
    }

    @Override
    public long long1() {
        return Long.parseLong(word());
    }

    @Override
    public String[] words(int n) {
        String[] result = new String[n];
        for (int i = 0; i < n; i++)
            result[i] = word();
        return result;
    }

    @Override
    public int[] ints(int n) {
        int[] result = new int[n];
        for (int i = 0; i < n; i++)
            result[i] = Integer.parseInt(word());
        return result;
    }

    @Override
    public long[] longs(int n) {
        long[] result = new long[n];
        for (int i = 0; i < n; i++)
            result[i] = Long.parseLong(word());
        return result;
    }
}
