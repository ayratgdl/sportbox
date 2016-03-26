package pw.fib.sportbox.io;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author ayratgdl
 * @date 26.03.16
 */
public class StringInTest {
    @Test
    public void wriateAndReadWordsTest() {
        StringIn in = new StringIn()
                .append("word1 ")
                .appendLn("word2 word3");
        assertEquals("word1", in.word());
        assertEquals("word2", in.word());
        assertEquals("word3", in.word());
    }

}