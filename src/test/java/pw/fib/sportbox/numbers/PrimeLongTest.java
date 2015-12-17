package pw.fib.sportbox.numbers;

import org.junit.Test;

import java.util.LinkedHashMap;

import static org.junit.Assert.assertEquals;

public class PrimeLongTest {
    @Test
    public void primeTest() {
        assertEquals(2, PrimeLong.prime(1));
        assertEquals(541, PrimeLong.prime(100));
    }

    @Test
    public void factoringTest() {
        LinkedHashMap<Long, Integer> factors = PrimeLong.factoring(4410);

        assertEquals(4, factors.keySet().size());

        Long[] nums = factors.keySet().toArray(new Long[factors.size()]);
        assertEquals(Long.valueOf(2), nums[0]);
        assertEquals(Integer.valueOf(1), factors.get(nums[0]));

        assertEquals(Long.valueOf(3), nums[1]);
        assertEquals(Integer.valueOf(2), factors.get(nums[1]));

        assertEquals(Long.valueOf(5), nums[2]);
        assertEquals(Integer.valueOf(1), factors.get(nums[2]));

        assertEquals(Long.valueOf(7), nums[3]);
        assertEquals(Integer.valueOf(2), factors.get(nums[3]));
    }
}
