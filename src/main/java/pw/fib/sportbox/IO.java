package pw.fib.sportbox;

import java.io.*;
import java.util.StringTokenizer;

public class IO {
    public static final In in = new In(new BufferedReader(new InputStreamReader(System.in)));
    public static final Out out = new Out(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static class In {
        private BufferedReader reader;
        StringTokenizer tokener;

        public In(BufferedReader reader) {
            this.reader = reader;
        }

        public String word() {
            try {
                if (tokener == null || !tokener.hasMoreTokens())
                    tokener = new StringTokenizer(reader.readLine());
                return tokener.nextToken();
            }
            catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public int int1() {
            return Integer.parseInt(word());
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

    public static class Out {
        private BufferedWriter writer;
        private boolean isEmptyLine = true;

        public Out(BufferedWriter writer) {
            this.writer = writer;
        }

        private Out write(String str) {
            try {
                if (!isEmptyLine)
                    writer.write(" ");
                else
                    isEmptyLine = false;
                writer.write(str);
                return this;
            }
            catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public Out ln() {
            try {
                writer.newLine();
                writer.flush();
                isEmptyLine = true;
                return this;
            }
            catch (IOException e) {
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
}