package com.kcar.debug;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MemoryLeakExample {
    private static final Map<Integer, byte[]> staticCache = new HashMap<>();

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1_000_000; i++) {
            // Adding large objects to staticCache
            staticCache.put(i, new byte[1024]); // 1KB object
            if (i % 10_000 == 0) {
//                removeOldEntries();
                System.out.println("Added " + i + " objects.");
                System.out.println("Cache size: " + staticCache.size());
                Thread.sleep(1000); // Slow down the loop for easier monitoring
            }
        }
    }

    private static void removeOldEntries() {
        Iterator<Map.Entry<Integer, byte[]>> iterator = staticCache.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, byte[]> entry = iterator.next();
            if (entry.getKey() % 2 == 0) { // Arbitrary condition to clean up
                iterator.remove();
            }
        }
    }
}