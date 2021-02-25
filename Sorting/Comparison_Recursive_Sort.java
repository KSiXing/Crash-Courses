/****
 *
 * @author Koh Si Xing
 *
 * This program tests out the comparison based Recursive algorithms
 * The algorithm itself is split into 2 portions divide and conquer portions
 *
 */

import java.util.Arrays;

public class Comparison_Recursive_Sort {
    public static void main(String[] args) {
        int [] integers = {3, 44, 56, 78, 32, 232, 5, 323, 498, 123, 6, 2, 1, 77, 23, 88};
        Sort2 s2 = new QuickSort();
        integers = s2.sort(integers, 0, integers.length - 1);

        System.out.println("\n----- Final Sorted Array -----");
        System.out.println(Arrays.toString(integers));
    }
}

abstract class Sort2 {

    public abstract int[] sort(int[] integers, int i, int j);

}

class MergeSort extends Sort2 {

    @Override
    public int[] sort(int [] integers, int i, int j) {
        if(i < j) {
            int mid = (i + j) / 2;
            sort(integers, i, mid);
            sort(integers, mid + 1, j);
            integers = merge(integers, i, mid, j);
        }
        return integers;
    }

    public int[] merge(int [] integers, int i, int mid, int j) {
        int[] tmp = new int[j- i + 1];

        int left = i;
        int right = mid + 1;
        int it = 0;

        while(left <= mid && right <= j) {
            if(integers[left] <= integers[right]) {
                tmp[it] = integers[left];
                left++;
            } else {
                tmp[it] = integers[right];
                right++;
            }
            it++;
        }

        while(left <= mid) {
            tmp[it++] = integers[left++];
        }

        while(right <= j) {
            tmp[it++] = integers[right++];
        }

        for(int k = 0; k < tmp.length; k++) {
            integers[i + k] = tmp[k];
        }

        System.out.println(Arrays.toString(tmp));
        return integers;
    }
}

class QuickSort extends Sort2 {

    @Override
    public int[] sort(int [] integers, int i, int j) {
        if (i < j) {
            int partitionIndex = partition(integers, i, j);
            sort(integers, i, partitionIndex-1);
            sort(integers, partitionIndex+1, j);
        }
        return integers;
    }

    public int partition(int [] integers, int i, int j) {
        int p = integers[i];
        int m = i;

        for(int k = i + 1; k <= j; k++) {
            if(integers[k] < p) {
                m++;
                integers = swap(integers, k, m);
            }
        }

        integers = swap(integers, i, m);
        System.out.println("Partition : " + p);
        System.out.println(Arrays.toString(integers));
        return m;
    }

    public int[] swap(int[] integers, int i, int j) {
        int tmp = integers[i];
        integers[i] = integers[j];
        integers[j] = tmp;

        return integers;
    }
}

class QuickSort2 extends Sort2 {

    /**
     * Same algorithm as QuickSort, except this version uses the last number as the partition
     * rather than the first. The changes can be seen in the Partition method
     */

    @Override
    public int[] sort(int [] integers, int i, int j) {
        if (i < j) {
            int partitionIndex = partition(integers, i, j);
            sort(integers, i, partitionIndex-1);
            sort(integers, partitionIndex+1, j);
        }
        return integers;
    }

    public int partition(int [] integers, int i, int j) {
        int p = integers[j];
        int m = j;

        for(int k = j - 1; k >= i; k--) {
            if(integers[k] > p) {
                m--;
                integers = swap(integers, k, m);
            }
        }

        integers = swap(integers, j, m);
        System.out.println("Partition : " + p);
        System.out.println(Arrays.toString(integers));
        return m;
    }

    public int[] swap(int[] integers, int i, int j) {
        int tmp = integers[i];
        integers[i] = integers[j];
        integers[j] = tmp;

        return integers;
    }
}
