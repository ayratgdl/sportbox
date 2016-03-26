package pw.fib.sportbox.io;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author ayratgdl
 * @date 26.03.16
 */
public class ExpectedOutTest {
    @Test
    public void expectedActualTest() {
        ExpectedOut out = new ExpectedOut();
        out.appendLn("Hello world");
        out.write("Hello world").ln();
        assertEquals(out.expected(), out.actual());
    }

}