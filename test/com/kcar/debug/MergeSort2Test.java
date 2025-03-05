package com.kcar.debug;

import org.junit.Test;

import static org.junit.Assert.*;

public class MergeSort2Test {
    // Correctly sorts an array of integers in ascending order
    @Test
    public void test_sort_array_ascending_order() {
        MergeSort2 mergeSort = new MergeSort2();
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        int[] expected = {11, 12, 22, 25, 34, 64, 90};

        mergeSort.sort(arr, 0, arr.length - 1);

        assertArrayEquals(expected, arr);
    }

    // Array with single element
    @Test
    public void test_sort_single_element_array() {
        MergeSort2 mergeSort = new MergeSort2();
        int[] arr = {42};
        int[] expected = {42};

        mergeSort.sort(arr, 0, arr.length - 1);

        assertArrayEquals(expected, arr);
    }

    // Successfully merges two sorted subarrays into a single sorted array
    @Test
    public void test_merge_sorted_subarrays() {
        MergeSort2 mergeSort = new MergeSort2();
        int[] arr = {1, 3, 5, 2, 4, 6};
        mergeSort.merge(arr, 0, 2, 5);
        int[] expected = {1, 2, 3, 4, 5, 6};
        assertArrayEquals(expected, arr);
    }

    // Handles arrays with even number of elements
    @Test
    public void test_sort_even_number_of_elements() {
        MergeSort2 mergeSort = new MergeSort2();
        int[] arr = {8, 4, 2, 6};
        mergeSort.sort(arr, 0, arr.length - 1);
        int[] expected = {2, 4, 6, 8};
        assertArrayEquals(expected, arr);
    }

    // Handles arrays with odd number of elements
    @Test
    public void test_sort_odd_number_of_elements() {
        MergeSort2 mergeSort = new MergeSort2();
        int[] arr = {9, 7, 5};
        mergeSort.sort(arr, 0, arr.length - 1);
        int[] expected = {5, 7, 9};
        assertArrayEquals(expected, arr);
    }
}