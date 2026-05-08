package lab01;

public class Task10 {
    public static int max(int[] array) {
        int maxValue = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] > maxValue) {
                maxValue = array[i];
            }
        }

        return maxValue;
    }

    public static void main(String[] args) {
        int[] numbers = {4, 8, 2, 15, 7};

        System.out.println(max(numbers));
    }
}