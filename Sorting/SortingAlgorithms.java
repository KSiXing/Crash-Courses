import java.util.Arrays;

/***
 *
 * @author KohSiXing
 *
 * This program tests out various sorting algorithms
 *
 */

public class SortingAlgorithms {
    public static void main(String[] args) {
        int [] integers = {3, 44, 56, 78, 32, 232, 5, 323, 498, 123, 6, 2, 1, 77, 23, 88};
        Sort s = new InsertionSort(integers);
        integers = s.sort();

        System.out.println("\n----- Final Sorted Array -----");
        System.out.println(Arrays.toString(integers));
    }
}

abstract class Sort {
    public abstract int[] sort();
}

class BubbleSort extends Sort{
    private int [] integers;

    public BubbleSort(int [] integers) {
        this.integers = integers;
    }

    @Override
    public int[] sort() {
        int n = this.integers.length;
        int comparison = 0;
        int swap = 0;

        for(int i = 0; i < n - 1; i++) {
            for(int j = 0; j < (n - i - 1); j++) {
                if(integers[j] > integers[j + 1]) {
                    int tmp = integers[j + 1];
                    integers[j + 1] = integers[j];
                    integers[j] = tmp;
                    swap++;
                }
                comparison++;
            }

            System.out.println("Pass : " + (i + 1));
            System.out.println(Arrays.toString(integers));
        }


        printStatistics(comparison, swap);
        return integers;
    }

    private void printStatistics(int comparisons, int swaps) {
        System.out.println("\n---- Statistics for Bubble Sort ----");
        System.out.println("Comparisons\t:\t" + comparisons);
        System.out.println("Swaps\t:\t\t" + swaps);
    }

}

class InsertionSort extends Sort{
    private int[] integers;

    public InsertionSort(int [] integers) {
        this.integers = integers;
    }

    @Override
    public int[] sort() {
        int n = this.integers.length;
        int comparison = 0;
        for (int i = 1; i < n; i++) {
            int next = integers[i];

            int j;
            for (j = i - 1; j >= 0 && integers[j] > next; j--) {
                System.out.println(next + " < " + integers[j]);
                integers[j + 1] = integers[j];
                comparison++;
            }
            integers[j + 1] = next;

            System.out.println("Pass : " + i + "\nNext : " + next);
            System.out.println(Arrays.toString(integers) + "\n");
        }

        printStatistics(comparison);
        return integers;
    }

    private void printStatistics(int comparisons) {
        System.out.println("\n---- Statistics for Insertion Sort ----");
        System.out.println("Comparisons\t:\t" + comparisons);
    }

}
