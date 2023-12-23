import java.util.Random;

public class Main {
    public static void main(String[] args) {

        int arrSize = 20;
        int[] arr;

        // Задание №1. Написать метод, возвращающий количество чётных элементов массива.
        // countEvens([2, 1, 2, 3, 4]) → 3 countEvens([2, 2, 0]) → 3 countEvens([1, 3, 5]) → 0
        System.out.println("\nЗадание №1:");
        arr = randomIntArr(arrSize, 1, 100);

        System.out.println(arrayIntToString(arr));
        System.out.println("Количество четных чисел в массиве: " + Taks01.countEvens(arr));


        // Задание №2. Написать функцию, возвращающую разницу между самым большим и самым
        // маленьким элементами переданного не пустого массива.
        System.out.println("\nЗадание №2:");

        arr = randomIntArr(arrSize, 1, 100);

        System.out.println(arrayIntToString(arr));

        int[] maxMinDiff = Task02.arrMaxMinDiff(arr);
        System.out.println("Разница между наибольшим и наименьшим элементами массива: " +
                maxMinDiff[0] + " - " + maxMinDiff[1] + " = " + maxMinDiff[2]);

        // Задание №3. Написать функцию, возвращающую истину, если в переданном массиве есть
        // два соседних элемента, с нулевым значением.
        System.out.println("\nЗадание №3:");

        arr = randomIntArr(arrSize, 0, 3);

        System.out.println(arrayIntToString(arr));
        System.out.println("В этом массиве есть два элемента подряд, равные нулю: " + Task03.hasArrayTwoZerosNext(arr));
    }

     public static int[] randomIntArr(int sz, int min, int max) {
        Random rand = new Random();
        int[] res = new int[sz];
        for (int i = 0; i < sz; i++) {
            res[i] = (int) (rand.nextInt((max - min) + 1) + min);
        }
        return res;
    }

    public static String arrayIntToString(int[] arr) {
        StringBuilder res = new StringBuilder("");
        res.append("[");
        for (int i : arr)
            res.append(i + "," + " ");

        return res.toString().substring(0, res.length() - 2) + "]";
    }

}