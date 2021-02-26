import java.util.Arrays;

/***
 *
 * @author KohSiXing
 *
 * This program tests out comparison based iterative algorithms
 *
 */

public class SortingAlgorithms {
    public static void main(String[] args) {
        int [] integers = {3, 44, 56, 78, 32, 232, 5, 323, 498, 123, 6, 2, 1, 77, 23, 88};
        Sort s = new SelectionSort(integers);
        integers = s.sort();

        System.out.println("\n----- Final Sorted Array -----");
        System.out.println(Arrays.toString(integers));
    }
}

abstract class Sort {
    public abstract int[] sort();
}

class BubbleSort extends Sort{
    /***
     *
     * Comparisons made : (n-1) + (n-2) + (n-3) + ... + 2 + 1 = n(n-1) / 2
     *
     */
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

class InsertionSort extends Sort {
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

class SelectionSort extends Sort{
    /***
     *
     * Comparisons made : (n-1) + (n-2) + (n-3) + ... + 2 + 1 = n(n-1)/2
     * Swaps made : (n-1)
     *
     */

    private int [] integers;

    public SelectionSort(int[] integers) {
        this.integers = integers;
    }

    @Override
    public int[] sort() {
        int n = this.integers.length;
        int comparison = 0;
        int swap = 0;
        int pass = 0;

        for(int i = this.integers.length - 1; i >= 1; i--) {
            int index = i;

            for(int j = 0; j < i; j++) {
                comparison++;
                if(integers[j] > integers[index]) {
                    index = j;
                }
            }

            int tmp = integers[index];
            integers[index] = integers[i];
            integers[i] = tmp;
            swap++;

            System.out.println("Pass : " + ++pass + "\nMax : " + tmp);
            System.out.println(Arrays.toString(integers) + "\n");
        }

        printStatistics(comparison, swap);
        return integers;
    }

    private void printStatistics(int comparisons, int swaps) {
        System.out.println("\n---- Statistics for Selection Sort ----");
        System.out.println("Comparisons\t:\t" + comparisons);
        System.out.println("Swaps\t:\t\t" + swaps);
    }

}
