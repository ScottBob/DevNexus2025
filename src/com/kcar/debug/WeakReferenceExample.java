package com.kcar.debug;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class WeakReferenceExample {
    private static List<WeakReference<byte[]>> cache = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1_000_000; i++) {
            // Using WeakReference
            cache.add(new WeakReference<>(new byte[1024])); // 1KB object
            if (i % 10_000 == 0) {
                System.out.println("Cache size: " + cache.size());
                Thread.sleep(500);
            }
        }
    }
}