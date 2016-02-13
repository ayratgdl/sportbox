package pw.fib.sportbox.bit;

/**
 * @author ayratgdl
 * @date 30.12.15
 *
 * Набор побитовых операций над числом
 */
public class BitOperations {
    public static int bitOf(long number, int position) {
        if (position < 0 || position > 63)
            throw new IllegalArgumentException("Position must be from 0 to 63. Actual position: " + position);

        return (number & (1L << position)) == 0 ? 0 : 1;
    }

    public static long changeBit(long number, int position, int value) {
        if (position < 0 || position > 63)
            throw new IllegalArgumentException("Position must be from 0 to 63. Actual position: " + position);
        if (value != 0 && value != 1)
            throw new IllegalArgumentException("Value must be 0 or 1. Actual value: " + value);

        if (value == 1) {
            return number | (1L << position);
        }
        else {
            return ~changeBit(~number, position, 1);
        }
    }

    public static int[] longToBitsArray(long number) {
        int[] array = new int[64];
        for (int i = 0; i < array.length; i++)
            array[i] = bitOf(number, i);
        return array;
    }

    public static long bitsArrayToLong(int[] array) {
        long number = 0;
        for (int i = 0; i < array.length; i++)
            if (array[i] == 1)
                number = BitOperations.changeBit(number, i, 1);
        return number;
    }
}
