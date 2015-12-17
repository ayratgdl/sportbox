package pw.fib.sportbox.numbers;

import org.junit.Test;

import java.util.LinkedHashMap;

import static org.junit.Assert.*;

public class PrimeIntTest {
    @Test
    public void primeTest() {
        assertEquals(2, PrimeInt.prime(1));
        assertEquals(541, PrimeInt.prime(100));
    }

    @Test
    public void factoringTest() {
        LinkedHashMap<Integer, Integer> factors = PrimeInt.factoring(4410);

        assertEquals(4, factors.keySet().size());

        Integer[] nums = factors.keySet().toArray(new Integer[factors.size()]);
        assertEquals(Integer.valueOf(2), nums[0]);
        assertEquals(Integer.valueOf(1), factors.get(nums[0]));

        assertEquals(Integer.valueOf(3), nums[1]);
        assertEquals(Integer.valueOf(2), factors.get(nums[1]));

        assertEquals(Integer.valueOf(5), nums[2]);
        assertEquals(Integer.valueOf(1), factors.get(nums[2]));

        assertEquals(Integer.valueOf(7), nums[3]);
        assertEquals(Integer.valueOf(2), factors.get(nums[3]));
    }
}
