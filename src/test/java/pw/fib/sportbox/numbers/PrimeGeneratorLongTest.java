package pw.fib.sportbox.numbers;

import org.junit.Assert;
import org.junit.Test;

public class PrimeGeneratorLongTest {
    @Test
    public void generatorTest() {
        PrimeLong.PrimeGeneratorLong gen = new PrimeLong.PrimeGeneratorLong();
        long[] gens = {gen.next(), gen.next(), gen.next()};
        long[] expected = {2, 3, 5};
        Assert.assertArrayEquals(expected, gens);
    }

    @Test
    public void generatorStartWithTest() {
        PrimeLong.PrimeGeneratorLong gen = new PrimeLong.PrimeGeneratorLong(100);
        long[] gens = {gen.next(), gen.next(), gen.next()};
        long[] expected = {541, 547, 557};
        Assert.assertArrayEquals(expected, gens);
    }

    @Test
    public void twoGeneratorsTest() {
        PrimeLong.PrimeGeneratorLong gen1 = new PrimeLong.PrimeGeneratorLong();
        PrimeLong.PrimeGeneratorLong gen2 = new PrimeLong.PrimeGeneratorLong();
        long[] gens = new long[3];
        gens[0] = gen1.next();
        gen2.next();
        gens[1] = gen1.next();
        gen2.next();
        gen2.next();
        gens[2] = gen1.next();
        long[] expected = {2, 3, 5};
        Assert.assertArrayEquals(expected, gens);
    }
}