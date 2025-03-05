package com.kcar.debug;

import java.util.ArrayList;
import java.util.List;

public class MergeSort3 {
    // Method to sort a collection of strings using Merge Sort
    public static List<String> sort(List<String> strings) {
        // Base case: if the list has 0 or 1 element, it's already sorted
        if (strings.size() <= 1) {
            return strings;
        }

        // Split the list into two halves
        int mid = strings.size() / 2;
        List<String> left = new ArrayList<>(strings.subList(0, mid));
        List<String> right = new ArrayList<>(strings.subList(mid, strings.size()));

        // Recursively sort both halves
        left = sort(left);
        right = sort(right);

        // Merge the sorted halves
        return merge(left, right);
    }

    // Helper method to merge two sorted lists
    private static List<String> merge(List<String> left, List<String> right) {
        List<String> merged = new ArrayList<>();
        int i = 0, j = 0;

        // Merge elements from both lists in sorted order
        while (i < left.size() && j < right.size()) {
            if (left.get(i).compareTo(right.get(j)) <= 0) {
                merged.add(left.get(i));
                i++;
            } else {
                merged.add(right.get(j));
                j++;
            }
        }

        // Add remaining elements from the left list
        while (i < left.size()) {
            merged.add(left.get(i));
            i++;
        }

        // Add remaining elements from the right list
        while (j < right.size()) {
            merged.add(right.get(j));
            j++;
        }

        return merged;
    }

    // Main method for testing
    public static void main(String[] args) {
        List<String> fruit = List.of("banana", "apple", "cherry", "blueberry", "date", "mango", "grape", "melon", "orange", "kiwi", "lemon", "nectarine", "peach", "strawberry", "watermelon");
        System.out.println("Original list: " + fruit);

        List<String> sortedStrings = sort(fruit);
        System.out.println("Sorted list: " + sortedStrings);
    }
}
