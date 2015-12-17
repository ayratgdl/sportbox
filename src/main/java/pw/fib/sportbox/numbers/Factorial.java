package pw.fib.sportbox.numbers;

import java.math.BigInteger;
import java.util.ArrayList;

public class Factorial {
    private static final ArrayList<BigInteger> facts = new ArrayList<>(100);
    static {
        facts.add(BigInteger.ONE);
    }

    public static BigInteger fact(int n) {
        int last = facts.size()-1;
        while (n > last) {
            facts.add(facts.get(last).multiply(BigInteger.valueOf(last+1)));
            last++;
        }
        return facts.get(n);
    }
}