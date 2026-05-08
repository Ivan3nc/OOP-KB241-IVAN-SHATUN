package lab01;

import java.util.Arrays;

public class Task14 {
    public static void cycleSwap(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }

        int lastElement = array[array.length - 1];

        for (int i = array.length - 1; i > 0; i--) {
            array[i] = array[i - 1];
        }

        array[0] = lastElement;
    }

    public static void cycleSwap(int[] array, int shift) {
        if (array == null || array.length == 0) {
            return;
        }

        shift = shift % array.length;

        for (int i = 0; i < shift; i++) {
            cycleSwap(array);
        }
    }

    public static void main(String[] args) {
        int[] firstArray = {1, 3, 2, 7, 4};
        cycleSwap(firstArray);
        System.out.println(Arrays.toString(firstArray));

        int[] secondArray = {1, 3, 2, 7, 4};
        cycleSwap(secondArray, 3);
        System.out.println(Arrays.toString(secondArray));
    }
}