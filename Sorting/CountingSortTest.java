/**
 *
 * @author KohSiXing
 *
 * This is a test for counting sort using positive integers
 * Counting sort works best with small range of values
 *
 */

import java.util.*;

public class CountingSortTest {
    public static void main(String[] args) {
        int [] integers = {0, 0, 3, 3, 2, 3, 5, 4, 8, 9, 1, 2, 2, 1};
        CountingSort cs = new CountingSort(integers);
        int [] sorted = cs.sort();
        System.out.println(Arrays.toString(sorted));
    }
}

class CountingSort {
    private final int [] integers;
    private int [] frequency;

    public CountingSort(int [] integers) {
        this.integers = integers;
        int max = Arrays.stream(integers).max().orElse(0);
        this.frequency = new int[max + 1];
    }

    public int[] sort() {
        for(int i = 0; i < integers.length; i++) { //Count the frequency of each distinct positive integer
            this.frequency[this.integers[i]]++;
        }

        for(int i=1; i < frequency.length; i++) { //Cumulative frequency of each distinct integer
            this.frequency[i] = this.frequency[i] + this.frequency[i-1];
        }

        int [] sorted = new int[integers.length];

        for(int i = 0; i < integers.length; i++) { // Place the integers in its sorted value based on the index in the frequency array
            System.out.println(this.frequency[this.integers[i]]);
            sorted[this.frequency[this.integers[i]] - 1] = this.integers[i];
            this.frequency[this.integers[i]]--;
        }

        return sorted;
    }
}
