public class Task03 {

    // Задание №3. Написать функцию, возвращающую истину, если в переданном массиве есть
    // два соседних элемента, с нулевым значением.
    public static boolean hasArrayTwoZerosNext(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == 0 && arr[i - 1] == 0) return true;
        }
        return false;
    }
}
