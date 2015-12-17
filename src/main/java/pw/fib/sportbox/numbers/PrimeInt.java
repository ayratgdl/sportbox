package pw.fib.sportbox.numbers;

import java.util.LinkedHashMap;

public class PrimeInt {
    private static int[] primes = new int[100];
    private static int count = 0;

    private static void add(int p) {
        if (count == primes.length) {
            int[] newPrimes = new int[2 * primes.length];
            System.arraycopy(primes, 0, newPrimes, 0, primes.length);
            primes = newPrimes;
        }
        primes[count++] = p;
    }

    private static int nextNew() {
        if (count == 0) {
            add(2);
            return 2;
        }

        int nxt = primes[count - 1];
        loop:
        while (true) {
            if (nxt == Integer.MAX_VALUE)
                throw new ArithmeticException("Next prime number larger Integer.MAX_VALUE");
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

    public static int prime(int n) {
        while (n > count)
            nextNew();

        return primes[n - 1];
    }

    // factoring of number
    // n > 1
    public static LinkedHashMap<Integer, Integer> factoring(int n) {
        LinkedHashMap<Integer, Integer> factors = new LinkedHashMap<>();

        PrimeInt.PrimeGeneratorInt gen = new PrimeInt.PrimeGeneratorInt();
        while (n != 1) {
            int p = gen.next();
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
    public static class PrimeGeneratorInt {
        private int nxtIndx;

        public PrimeGeneratorInt() {
            nxtIndx = 1;
        }

        // startIndex >= 1
        public PrimeGeneratorInt(int startIndex) {
            nxtIndx = startIndex;
        }

        public int next() {
            while (nxtIndx > count)
                nextNew();

            return primes[(nxtIndx++) - 1];
        }
    }
}