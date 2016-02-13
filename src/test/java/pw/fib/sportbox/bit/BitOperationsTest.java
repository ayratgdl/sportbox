package pw.fib.sportbox.bit;

import org.junit.Test;

import static org.junit.Assert.*;
import static pw.fib.sportbox.bit.BitOperations.*;

/**
 * @author ayratgdl
 * @date 30.12.15
 */
public class BitOperationsTest {

    @Test
    public void testBitOf() throws Exception {
        assertEquals(0, bitOf(0, 0));
        assertEquals(1, bitOf(1, 0));
        assertEquals(0, bitOf(2, 0));
        assertEquals(1, bitOf(2, 1));
        assertEquals(0, bitOf(18, 3));
        assertEquals(1, bitOf(18, 1));

        assertEquals(0, bitOf(0, 2));
        assertEquals(0, bitOf(1, 2));
    }

    @Test
    public void testBitOfBadArguments() throws Exception {
        bitOfBadArguments(0, -1);
        bitOfBadArguments(0, 64);
    }

    private void bitOfBadArguments(long number, int index) throws Exception {
        try {
            bitOf(number, index);
        } catch (IllegalArgumentException e) {
            return;
        }
        fail();
    }

    @Test
    public void testChangeBit() throws Exception {
        // set "1"
        assertEquals(1, changeBit(0, 0, 1));
        assertEquals(2, changeBit(0, 1, 1));
        assertEquals(3, changeBit(2, 0, 1));

        // set "0"
        assertEquals(0, changeBit(0, 0, 0));
        assertEquals(2, changeBit(3, 0, 0));
    }

    @Test
    public void testLongToBitsArray() throws Exception {
        assertArrayEquals(new ArrayBuilder().build(), longToBitsArray(0));
        assertArrayEquals(new ArrayBuilder().one(0).build(), longToBitsArray(1));
        assertArrayEquals(new ArrayBuilder().one(0).one(2).build(), longToBitsArray(5));
    }

    private static class ArrayBuilder {
        private final int[] array = new int[64];

        ArrayBuilder one(int position) {
            array[position] = 1;
            return this;
        }

        int[] build() {
            return array;
        }
    }

    @Test
    public void testBitsArrayToLong() throws Exception {
        assertEquals(0, bitsArrayToLong(new ArrayBuilder().build()));
        assertEquals(1, bitsArrayToLong(new ArrayBuilder().one(0).build()));
        assertEquals(5, bitsArrayToLong(new ArrayBuilder().one(0).one(2).build()));
    }
}