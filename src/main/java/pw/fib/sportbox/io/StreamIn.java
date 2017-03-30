package pw.fib.sportbox.io;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author ayratgdl
 * @date 26.03.16
 */
public class StreamIn {
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

    public int int1() {
        return Integer.parseInt(word());
    }

    public String word() {
        try {
            if (tokener == null || !tokener.hasMoreTokens())
                tokener = new StringTokenizer(reader.readLine());
            return tokener.nextToken();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public long long1() {
        return Long.parseLong(word());
    }

    public String[] words(int n) {
        String[] result = new String[n];
        for (int i = 0; i < n; i++)
            result[i] = word();
        return result;
    }

    public int[] ints(int n) {
        int[] result = new int[n];
        for (int i = 0; i < n; i++)
            result[i] = Integer.parseInt(word());
        return result;
    }

    public long[] longs(int n) {
        long[] result = new long[n];
        for (int i = 0; i < n; i++)
            result[i] = Long.parseLong(word());
        return result;
    }
}
