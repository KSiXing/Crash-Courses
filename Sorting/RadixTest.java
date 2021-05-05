/**
 *
 * @author KohSiXing
 *
 * This is a test for radix sort using positive integers
 *
 */

import java.util.*;

public class RadixTest {
    public static void main(String[] args) {
        int [] integers = {3, 44, 56, 78, 32, 232, 5, 323, 498, 123, 6, 2, 1, 77, 23, 88};
        int max = Arrays.stream(integers).max().orElse(0);

        int maxDigits = 0;
        while(max > 0) {
            max /= 10;
            maxDigits++;
        }

        Radix radix = new Radix(integers);

        int exp = 1;
        while(maxDigits > 0) {
            System.out.println("Pass : " + (int) (Math.log10(exp) + 1));
            integers = radix.sort(exp);
            exp *= 10;
            maxDigits--;
        }

        System.out.println("\n----- Final Sorted Array -----");
        System.out.println(Arrays.toString(integers));
    }
}

class Radix {
    private int [] integers;

    public Radix(int [] integers) {
        this.integers = integers;
    }

    public int[] sort(int exp) {
        int [] count = new int[10];
        int [] tmp = new int[integers.length];

        for(int i : integers) {
            count[(i/exp) % 10]++;
        }

        for (int i = 1; i < 10; i++)
            count[i] += count[i - 1];

        for (int i = integers.length - 1; i >= 0; i--) {
            tmp[count[(integers[i] / exp) % 10] - 1] = integers[i];
            count[(integers[i] / exp) % 10]--;
        }

        for (int i = 0; i < integers.length; i++){
            integers[i] = tmp[i];
        }

        System.out.println(Arrays.toString(integers));
        return this.integers;
    }
}
