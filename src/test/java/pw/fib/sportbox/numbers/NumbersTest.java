package pw.fib.sportbox.numbers;

import org.junit.Test;

import static org.junit.Assert.*;

public class NumbersTest {
    @Test
    public void gcdIntTest() {
        assertEquals(6, Numbers.gcd(30, 42));
    }

    @Test
    public void gcd1And50IntTest() {
        assertEquals(1, Numbers.gcd(1, 50));
    }

    @Test
    public void gcdLongTest() {
        assertEquals(6, Numbers.gcd(30L, 42L));
    }

    @Test
    public void gcd1And50LongTest() {
        assertEquals(1, Numbers.gcd(1L, 50L));
    }

    @Test
    public void lcmIntTest() {
        assertEquals(105, Numbers.lcm(15, 21));
    }

    @Test
    public void lcm1And50IntTest() {
        assertEquals(50, Numbers.lcm(1, 50));
    }

    @Test
    public void lcmLongTest() {
        assertEquals(105, Numbers.lcm(15L, 21L));
    }

    @Test
    public void lcm1And50LongTest() {
        assertEquals(50, Numbers.lcm(1L, 50L));
    }
}