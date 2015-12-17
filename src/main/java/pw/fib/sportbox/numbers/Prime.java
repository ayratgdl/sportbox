package pw.fib.sportbox.numbers;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Prime {
    private static final List<BigInteger> primes = new ArrayList<>(1000);
    static {
        primes.add(BigInteger.valueOf(2));
    }

    private static BigInteger nextNew() {
        BigInteger nxt = primes.get(primes.size()-1);
        loop: while (true) {
            nxt = nxt.add(BigInteger.ONE);
            for (int p = 0; p < primes.size(); p++) {
                if (nxt.mod(primes.get(p)).equals(BigInteger.ZERO)) {
                    continue loop;
                }
            }
            primes.add(nxt);
            return nxt;
        }
    }

    // n > 0
    public static BigInteger prime(int n) {
        while (n > primes.size())
            nextNew();

        return primes.get(n-1);
    }

    public static class PrimeGenerator {
        private int nxtIndx = 1;

        public BigInteger next() {
            while (nxtIndx > primes.size())
                nextNew();

            return primes.get((nxtIndx++)-1);
        }
    }
}