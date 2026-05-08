package lab01;

public class Task11 {
    public static int sum(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }

        int result = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                result += array[i];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6};

        System.out.println(sum(numbers));
    }
}