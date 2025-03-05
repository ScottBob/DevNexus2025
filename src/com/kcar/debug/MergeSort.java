package com.kcar.debug;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        String[] values = {"foo", "bar", "alice", "bob", "celine", "david"};
        mergeSort(values, 0, values.length - 1);
        System.out.println("Sorted array: " + Arrays.toString(values));
    }

    public static void mergeSort(String[] a, int from, int to) {
        if (from == to) {
            return; // Base case: single element, no need to sort
        }
        int mid = (from + to) / 2 - 1;
        mergeSort(a, from, mid); // Sort the first half
        mergeSort(a, mid + 1, to); // Sort the second half
        merge(a, from, mid, to); // Merge the sorted halves
    }

    public static void merge(String[] a, int from, int mid, int to) {
        if (mid < 1) return;
        int n = to - from; // Size of the range to be merged
        String[] b = new String[n]; // Temporary array for merging

        int i1 = from; // Next element to consider in the first range
        int i2 = mid; // Next element to consider in the second range
        int j = 0; // Next open position in b

        // Merge elements from both halves into the temporary array b
        while (i1 <= mid && i2 <= to && j < n) {
            if (a[i1].compareTo(a[i2]) < 0) {
                b[j] = a[i1];
                i1++;
            } else {
                b[j] = a[i2];
                i2++;
            }
            j++;
        }

        // Copy any remaining entries from the first half
        while (i1 <= mid && j < n) {
            b[j] = a[i1];
            i1++;
            j++;
        }

        // Copy any remaining entries from the second half
        while (i2 <= to && j < n) {
            b[j] = a[i2];
            i2++;
            j++;
        }

        // Copy back from the temporary array to the original array a
        for (j = 0; j < n; j++) {
            a[from + j] = b[j];
        }
    }
}
