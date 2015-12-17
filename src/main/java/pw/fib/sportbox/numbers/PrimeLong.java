package pw.fib.sportbox.numbers;

import java.util.LinkedHashMap;

public class PrimeLong {
    private static long[] primes = new long[100];
    private static int count = 0;

    private static void add(long p) {
        if (count == primes.length) {
            long[] newPrimes = new long[2 * primes.length];
            System.arraycopy(primes, 0, newPrimes, 0, primes.length);
            primes = newPrimes;
        }
        primes[count++] = p;
    }

    private static long nextNew() {
        if (count == 0) {
            add(2);
            return 2;
        }

        long nxt = primes[count - 1];
        loop:
        while (true) {
            if (nxt == Long.MAX_VALUE)
                throw new ArithmeticException("Next prime number larger Long.MAX_VALUE");
            nxt++;
            for (int i = 0; i < count; i++) {
                if (nxt % primes[i] == 0) {
                    continue loop;
                }
            }
            add(nxt);
            return nxt;
        }
    }

    public static long prime(int n) {
        while (n > count)
            nextNew();

        return primes[n - 1];
    }

    // factoring of number
    // n > 1
    public static LinkedHashMap<Long, Integer> factoring(long n) {
        LinkedHashMap<Long, Integer> factors = new LinkedHashMap<>();

        PrimeInt.PrimeGeneratorInt gen = new PrimeInt.PrimeGeneratorInt();
        while (n != 1) {
            long p = gen.next();
            int count = 0;
            while (n % p == 0) {
                count++;
                n /= p;
            }
            if (count > 0)
                factors.put(p, count);
        }

        return factors;
    }

    /**
     * Generator of prime numbers
     */
    public static class PrimeGeneratorLong {
        private int nxtIndx;

        public PrimeGeneratorLong() {
            nxtIndx = 1;
        }

        // startIndex >= 1
        public PrimeGeneratorLong(int startIndex) {
            nxtIndx = startIndex;
        }

        public long next() {
            while (nxtIndx > count)
                nextNew();

            return primes[(nxtIndx++) - 1];
        }
    }
}