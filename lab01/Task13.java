package lab01;

import java.util.Arrays;

public class Task13 {
    public static int[] removeLocalMaxima(int[] array) {
        int newSize = 0;

        for (int i = 0; i < array.length; i++) {
            if (!isLocalMaximum(array, i)) {
                newSize++;
            }
        }

        int[] result = new int[newSize];
        int index = 0;

        for (int i = 0; i < array.length; i++) {
            if (!isLocalMaximum(array, i)) {
                result[index] = array[i];
                index++;
            }
        }

        return result;
    }

    private static boolean isLocalMaximum(int[] array, int index) {
        if (index == 0) {
            return array[index] > array[index + 1];
        }

        if (index == array.length - 1) {
            return array[index] > array[index - 1];
        }

        return array[index] > array[index - 1] && array[index] > array[index + 1];
    }

    public static void main(String[] args) {
        int[] numbers = {18, 1, 3, 6, 7, -5};

        System.out.println(Arrays.toString(removeLocalMaxima(numbers)));
    }
}