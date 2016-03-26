package pw.fib.sportbox.io;

import org.junit.Test;
import pw.fib.sportbox.io.StreamOut;

import static org.junit.Assert.*;

import java.io.*;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

public class StreamOutTest {
    @Test
    public void writeObjectTest() {
        StringWriter writer = new StringWriter();
        StreamOut out = new StreamOut(new BufferedWriter(writer));

        out.write(new BigInteger("123456")).ln();
        assertEquals("123456" + System.lineSeparator(), writer.toString());
    }

    @Test
    public void writeStringTest() {
        StringWriter writer = new StringWriter();
        StreamOut out = new StreamOut(new BufferedWriter(writer));

        out.write("Hello World!").ln();
        assertEquals("Hello World!" + System.lineSeparator(), writer.toString());
    }

    @Test
    public void writeIntTest() {
        StringWriter writer = new StringWriter();
        StreamOut out = new StreamOut(new BufferedWriter(writer));

        out.write(1).ln();
        assertEquals("1" + System.lineSeparator(), writer.toString());
    }

    @Test
    public void writeLongTest() {
        StringWriter writer = new StringWriter();
        StreamOut out = new StreamOut(new BufferedWriter(writer));

        out.write(1L).ln();
        assertEquals("1" + System.lineSeparator(), writer.toString());
    }

    @Test
    public void writeObjectsArraysTest() {
        StringWriter writer = new StringWriter();
        StreamOut out = new StreamOut(new BufferedWriter(writer));

        out.write(new BigInteger[]{new BigInteger("123456"), new BigInteger("78910")}).ln();
        assertEquals("123456 78910" + System.lineSeparator(), writer.toString());
    }

    @Test
    public void writeIterableTest() {
        StringWriter writer = new StringWriter();
        StreamOut out = new StreamOut(new BufferedWriter(writer));

        List<Long> list = Arrays.asList(1L, 2L, 3L);
        out.write(list).ln();
        assertEquals("1 2 3" + System.lineSeparator(), writer.toString());
    }

    @Test
    public void writeIntsArrayTest() throws IOException {
        StringWriter writer = new StringWriter();

        StreamOut out = new StreamOut(new BufferedWriter(writer));

        int[] array = new int[]{1, 2, 3, 4};
        out.write(array).ln();

        assertEquals("1 2 3 4" + System.lineSeparator(), writer.toString());
    }

    @Test
    public void writeIntsTest() throws IOException {
        StringWriter writer = new StringWriter();

        StreamOut out = new StreamOut(new BufferedWriter(writer));

        out .write(new int[]{1, 2, 3, 4}).ln();

        assertEquals("1 2 3 4" + System.lineSeparator(), writer.toString());
    }

    @Test
    public void writeLongsTest() throws IOException {
        StringWriter writer = new StringWriter();

        StreamOut out = new StreamOut(new BufferedWriter(writer));

        out.write(new long[]{1L, 2L, 3L, 4L}).ln();

        assertEquals("1 2 3 4" + System.lineSeparator(), writer.toString());
    }

    @Test
    public void writeIntsIntsArrayLnIntsTest() throws IOException {
        StringWriter writer = new StringWriter();

        StreamOut out = new StreamOut(new BufferedWriter(writer));

        out.write(1).write(new int[]{2, 3, 4}).ln().write(new int[]{5, 6}).ln();

        assertEquals("1 2 3 4" + System.lineSeparator() + "5 6" + System.lineSeparator(), writer.toString());
    }
}
