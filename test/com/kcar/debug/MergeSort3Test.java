package com.kcar.debug;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MergeSort3Test {
    // Merge two sorted halves of array into single sorted array
    @Test
    public void test_merge_sorted_halves() {
        List<String> input = List.of("apple", "dog", "banana", "cat");
        int from = 0;
        int to = 3;

        List<String> sorted = MergeSort3.sort(input);

        List<String> expected = List.of("apple", "banana", "cat", "dog");
        assertArrayEquals(expected.toArray(), sorted.toArray());
    }

    // Merge when input array contains identical strings
    @Test
    public void test_merge_with_duplicates() {
        List<String> input = List.of("cat", "dog", "cat", "bird");
        int from = 0;
        int to = 3;

        List<String> sorted = MergeSort3.sort(input);

        List<String> expected = List.of("bird", "cat", "cat", "dog");
        assertArrayEquals(expected.toArray(), sorted.toArray());
    }

    // Correctly merge arrays when first half is smaller than second half
    @Test
    public void test_merge_first_half_smaller() {
        List<String> input = List.of("grape", "fig", "date", "cherry", "banana", "apple");
        List<String> sorted = MergeSort3.sort(input);
        List<String> expected = List.of("apple", "banana", "cherry", "date", "fig", "grape");
        assertArrayEquals(expected.toArray(), sorted.toArray());
    }

    // Correctly merge arrays when second half is smaller than first half
    @Test
    public void test_merge_second_half_smaller() {
        List<String> input = List.of("grape", "fig", "date", "cherry", "banana", "apple");
        List<String> sorted = MergeSort3.sort(input);
        List<String> expected = List.of("apple", "banana", "cherry", "date", "fig", "grape");
        assertArrayEquals(expected.toArray(), sorted.toArray());
    }

    // Preserve original string values during merge operation
    @Test
    public void test_preserve_original_values() {
        List<String> input = List.of("kiwi", "lemon", "mango", "nectarine");
        List<String> original = new ArrayList<>(input);
        List<String> sorted = MergeSort3.sort(input);
        assertArrayEquals(sorted.toArray(), input.toArray());
        assertArrayEquals(original.toArray(), input.toArray());
    }

}