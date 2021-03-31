package ru.job4j;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        int[] arr = new int[100000];
        for (int i = 0; i < 99999; i++) {
            arr[i] = i;
        }

        System.out.println(binarySearch(49999, arr));
    }

    public static int binarySearch(int x, int[] arr) {
        int count = 0;
        int low = 0;
        int high = arr.length - 1;
        int middle = low + high / 2;
        while(true) {
            if (arr[middle] < x) {
                low = middle;
                middle = (high + low) / 2;
                count++;
            } else if (arr[middle] > x) {
                high = middle;
                middle = (high + low) / 2;
                count++;
            } else {
                break;
            }
        }
        System.out.println("index = " + middle + " number = " + arr[middle]);
        System.out.println("count = " + count);
        return arr[middle];
    }


    // [0, 1, 2, 3, 4, 5, 6, 7, 8, 9] 10 /2 = 5
}
