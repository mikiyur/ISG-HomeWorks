package hw3_insertionSort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = insertionSort(new int[]{9, 7, 5, 1, 8, 6, 4, 2});
        System.out.println(Arrays.toString(arr));
    }

    private static int[] insertionSort(int[] arr) {
        int index;
        for (int i = 1; i < arr.length; i++) {
            index = i;
            while (index >= 1 && arr[index] < arr[index - 1]) {
                int temp = arr[index];
                arr[index] = arr[index - 1];
                arr[index - 1] = temp;
                index--;
            }
        }
        return arr;
    }
}
