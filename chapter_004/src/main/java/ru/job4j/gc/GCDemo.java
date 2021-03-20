package ru.job4j.gc;

public class GCDemo {

    private static final long KB = 1024;
    private static final long MB = KB * KB;
    private static final Runtime ENVIRONMENT = Runtime.getRuntime();

    public void info() {
        final long freeMemory = ENVIRONMENT.freeMemory();
        final long totalMemory = ENVIRONMENT.totalMemory();
        final long maxMemory = ENVIRONMENT.maxMemory();
        System.out.println("=== Environment state ===");
        System.out.printf("Free: %d%n", freeMemory );
        System.out.printf("Total: %d%n", totalMemory );
        System.out.printf("Max: %d%n", maxMemory );
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++) {
            new Person(i, "N" + i);
        }
    }
}