package pw.fib.sportbox;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

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
}
