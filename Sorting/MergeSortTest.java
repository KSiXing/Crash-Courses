/****
 *
 * @author Koh Si Xing
 *
 * This program tests out the Merge Sort Algorithm
 * The algorithm itself is split into 2 portions the Sort (Divide) and Merge (Conquer) portions
 *
 */

import java.util.Arrays;

public class MergeSortTest {
    public static void main(String[] args) {
        int [] integers = {3, 44, 56, 78, 32, 232, 5, 323, 498, 123, 6, 2, 1, 77, 23, 88};
        MergeSort ms = new MergeSort();
        integers = ms.sort(integers, 0, integers.length - 1);

        System.out.println("\n----- Final Sorted Array -----");
        System.out.println(Arrays.toString(integers));
    }
}

class MergeSort {

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
