package pw.fib.sportbox.numbers;

import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.*;

public class FactorialTest {
    @Test
    public void fact0Test() {
        BigInteger fact0 = Factorial.fact(0);
        assertEquals(BigInteger.ONE, fact0);
    }

    @Test
    public void fact5_0_3Test() {
        BigInteger fact7 = Factorial.fact(7);
        BigInteger fact0 = Factorial.fact(0);
        BigInteger fact5 = Factorial.fact(5);

        assertEquals(BigInteger.valueOf(5040), fact7);
        assertEquals(BigInteger.ONE, fact0);
        assertEquals(BigInteger.valueOf(120), fact5);
    }
}
