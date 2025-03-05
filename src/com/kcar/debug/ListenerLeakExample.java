package com.kcar.debug;

import java.util.ArrayList;
import java.util.List;

public class ListenerLeakExample {
    // Global list simulating listener registration
    private static final List<Runnable> listeners = new ArrayList<>();


//    public static void main(String[] args) throws InterruptedException { int count = 0;
//        while (true) {
//            Thingie thingie = new Thingie("Thing" + count++);
//            // Registering a listener that retains a reference to 'object'
//            listeners.add(() -> System.out.println(thingie.hashCode()));
//
//            // Even after 'object' goes out of scope, it's still referenced in listeners
//            Thread.sleep(100); // Simulating a running application
//        }
//    }
    public static void main(String[] args) throws InterruptedException {
         int count = 0;
        while (true) {
            Thingie thingie = new Thingie("Thing" + count++);
            Runnable listener = () -> System.out.println(thingie.hashCode());
            listeners.add(listener);

            // Simulate cleaning up unused listeners
            if (listeners.size() > 10) { // Arbitrary cleanup condition
                listeners.clear();
            }

            Thread.sleep(100); // Simulating a running application
        }
    }
    record Thingie(String name) { }
}