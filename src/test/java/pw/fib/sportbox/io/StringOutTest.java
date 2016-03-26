package pw.fib.sportbox.io;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author ayratgdl
 * @date 26.03.16
 */
public class StringOutTest {
    @Test
    public void toStringTest(){
        StringOut out = new StringOut();
        out.write("Hello world!").ln();
        assertEquals("Hello world!"+System.lineSeparator(), out.toString());
    }

}