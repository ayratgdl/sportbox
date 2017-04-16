package pw.fib.sportbox.test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Random;

/**
 * @author ayratgdl
 * @date 30.03.17
 */
public class TestUtil {
    private static ByteArrayOutputStream out;

    public static InputStream input(String lines) {
        return new ByteArrayInputStream(lines.getBytes());
    }

    public static OutputStream output() {
        out = new ByteArrayOutputStream();
        return out;
    }

    public static String outputContent() {
        return out.toString();
    }

    public static String generateString(int count) {
        StringBuilder result = new StringBuilder();
        Random random = new Random();
        while (count-- > 0) {
            int offset = random.nextInt(26);
            char character = (char) ('a' + offset);
            result.append(character);
        }
        return result.toString();
    }
}
