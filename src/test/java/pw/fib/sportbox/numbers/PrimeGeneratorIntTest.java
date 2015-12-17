package pw.fib.sportbox.numbers;

import org.junit.Assert;
import org.junit.Test;

public class PrimeGeneratorIntTest {
    @Test
    public void generatorTest() {
        PrimeInt.PrimeGeneratorInt gen = new PrimeInt.PrimeGeneratorInt();
        int[] gens = {gen.next(), gen.next(), gen.next()};
        int[] expected = {2, 3, 5};
        Assert.assertArrayEquals(expected, gens);
    }

    @Test
    public void generatorStartWithTest() {
        PrimeInt.PrimeGeneratorInt gen = new PrimeInt.PrimeGeneratorInt(100);
        int[] gens = {gen.next(), gen.next(), gen.next()};
        int[] expected = {541, 547, 557};
        Assert.assertArrayEquals(expected, gens);
    }

    @Test
    public void twoGeneratorsTest() {
        PrimeInt.PrimeGeneratorInt gen1 = new PrimeInt.PrimeGeneratorInt();
        PrimeInt.PrimeGeneratorInt gen2 = new PrimeInt.PrimeGeneratorInt();
        int[] gens = new int[3];
        gens[0] = gen1.next();
        gen2.next();
        gens[1] = gen1.next();
        gen2.next();
        gen2.next();
        gens[2] = gen1.next();
        int[] expected = {2, 3, 5};
        Assert.assertArrayEquals(expected, gens);
    }
}