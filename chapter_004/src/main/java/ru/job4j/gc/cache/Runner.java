package ru.job4j.gc.cache;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        SoftCache softCache = new SoftCache();
        String answer = scan();
        while (!answer.equals("exit")) {
            if (answer.equals("gc")) {
                System.gc();
                System.out.println("GC");
                answer = scan();
                continue;
            }
            System.out.println(softCache.getData(answer).length());
            answer = scan();
        }
    }

    private static String scan() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter file name: ");
        return scanner.next();
    }
}
