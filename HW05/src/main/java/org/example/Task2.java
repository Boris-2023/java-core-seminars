package org.example;
// Задание №2
// Предположить, что числа в исходном массиве из 9 элементов имеют диапазон[0, 3], и представляют собой,
// например, состояния ячеек поля для игры в крестикинолики, где 0 – это пустое поле, 1 – это поле с крестиком,
// 2 – это поле с ноликом, 3 – резервное значение. Такое предположение позволит хранить в одном числе типа int
// всё поле 3х3. Записать в файл 9 значений так, чтобы они заняли три байта.

import java.io.*;
import java.util.Arrays;

public class Task2 {
    public static void main(String[] args) {
        int[] state = {3, 3, 3, 0, 1, 2, 0, 2, 1};
        String fileName = "tick-tack-toe";

        try {
            saveState(state, fileName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void saveState(int[] state, String fileName) throws FileNotFoundException, IOException {

        File file = new File(fileName);
        byte[] toWrite = new byte[3];

        for (int i = 0; i < 3; i++) {
            toWrite[i] = (byte) (convert4To10(state[i * 3], state[i * 3 + 1], state[i * 3 + 2]));
        }

        System.out.print("\nWriting tick-tack-toe state ... ");

        FileOutputStream outFile = new FileOutputStream(file);
        outFile.write(toWrite);
        outFile.close();

        System.out.println("done!");

    }

    public static Byte convert4To10(int val1, int val2, int val3) {
        return (byte) (val1 * 16 + val2 * 4 + val3);
    }

    public static int[] convert10To4(int value) {
        int[] arr = new int[3];
        int res = value;
        int cnt = 0;
        while (res > 0) {
            arr[cnt] = res % 4;
            System.out.println(res + " -> " + arr[cnt]);
            res /= 4;
            cnt++;
        }
        return arr;
    }

}
