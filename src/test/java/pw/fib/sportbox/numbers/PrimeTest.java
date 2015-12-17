package pw.fib.sportbox.numbers;

import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.*;

public class PrimeTest {
    @Test
    public void primeTest() {
        assertEquals(BigInteger.valueOf(2), Prime.prime(1));
        assertEquals(BigInteger.valueOf(541), Prime.prime(100));
    }
}
