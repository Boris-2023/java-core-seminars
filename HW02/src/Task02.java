public class Task02 {

    // Задание №2. Написать функцию, возвращающую разницу между самым большим и самым
    // маленьким элементами переданного не пустого массива.
    public static int[] arrMaxMinDiff(int[] arr) {
        int maxVal = Integer.MIN_VALUE;
        int minVal = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (maxVal < arr[i]) maxVal = arr[i];
            if (minVal > arr[i]) minVal = arr[i];
        }

        return new int[]{maxVal, minVal, maxVal - minVal};
    }
}
