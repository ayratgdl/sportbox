package pw.fib.sportbox.io;

import org.junit.Test;
import pw.fib.sportbox.io.StreamIn;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.StringReader;

public class StreamInTest {
    @Test
    public void wordTest() {
        StreamIn in = new StreamIn(new BufferedReader(new StringReader("Hello World!")));

        assertEquals("Hello", in.word());
        assertEquals("World!", in.word());
    }

    @Test
    public void int1Test() {
        StreamIn in = new StreamIn(new BufferedReader(new StringReader("123 456\n789")));

        assertEquals(123, in.int1());
        assertEquals(456, in.int1());
        assertEquals(789, in.int1());
    }

    @Test
    public void long1Test() {
        StreamIn in = new StreamIn(new BufferedReader(new StringReader("123 456\n7890000000")));

        assertEquals(123, in.long1());
        assertEquals(456, in.long1());
        assertEquals(7890000000L, in.long1());
    }

    @Test
    public void wordsTest() {
        StreamIn in = new StreamIn(new BufferedReader(new StringReader("Hello world!")));

        assertArrayEquals(new String[]{"Hello", "world!"}, in.words(2));
    }

    @Test
    public void intsTest() {
        StreamIn in = new StreamIn(new BufferedReader(new StringReader("123 456\n789")));

        assertArrayEquals(new int[]{123, 456, 789}, in.ints(3));
    }

    @Test
    public void longsTest() {
        StreamIn in = new StreamIn(new BufferedReader(new StringReader("123 456\n7890000000")));

        assertArrayEquals(new long[]{123L, 456L, 7890000000L}, in.longs(3));
    }

    @Test
    public void int1Int1LongsInt1Test() {
        StreamIn in = new StreamIn(new BufferedReader(new StringReader("123 456 7890000000 7890000001 5")));

        assertEquals(123, in.int1());
        assertEquals(456, in.int1());
        assertArrayEquals(new long[]{7890000000L, 7890000001L}, in.longs(2));
        assertEquals(5, in.int1());
    }
}
