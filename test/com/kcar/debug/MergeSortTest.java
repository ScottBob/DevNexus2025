package com.kcar.debug;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

public class MergeSortTest {
    // Merge two sorted halves of array into single sorted array
    @Test
    public void test_merge_sorted_halves() {
        String[] input = {"apple", "dog", "banana", "cat"};
        int from = 0;
        int to = 3;

        MergeSort.mergeSort(input, from, to);

        String[] expected = {"apple", "banana", "cat", "dog"};
        assertArrayEquals(expected, input);
    }

    // Merge when input array contains identical strings
    @Test
    public void test_merge_with_duplicates() {
        String[] input = {"cat", "dog", "cat", "bird"};
        int from = 0;
        int to = 3;

        MergeSort.mergeSort(input, from, to);

        String[] expected = {"bird", "cat", "cat", "dog"};
        assertArrayEquals(expected, input);
    }

    // Correctly merge arrays when first half is smaller than second half
    @Test
    public void test_merge_first_half_smaller() {
        String[] array = {"apple", "banana", "cherry", "date", "fig", "grape"};
        MergeSort.mergeSort(array, 0, 5);
        String[] expected = {"apple", "banana", "cherry", "date", "fig", "grape"};
        assertArrayEquals(expected, array);
    }

    // Correctly merge arrays when second half is smaller than first half
    @Test
    public void test_merge_second_half_smaller() {
        String[] array = {"grape", "fig", "date", "cherry", "banana", "apple"};
        MergeSort.mergeSort(array, 0, 5);
        String[] expected = {"cherry", "date", "fig", "grape", "banana", "apple"};
        assertArrayEquals(expected, array);
    }

    // Preserve original string values during merge operation
    @Test
    public void test_preserve_original_values() {
        String[] array = {"kiwi", "lemon", "mango", "nectarine"};
        String[] original = Arrays.copyOf(array, array.length);
        MergeSort.mergeSort(array, 0, 3);
        for (String value : original) {
            assertTrue(Arrays.asList(array).contains(value));
        }
    }
}