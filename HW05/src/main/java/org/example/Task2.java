package org.example;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

// Задание №2
// Предположить, что числа в исходном массиве из 9 элементов имеют диапазон[0, 3], и представляют собой,
// например, состояния ячеек поля для игры в крестикинолики, где 0 – это пустое поле, 1 – это поле с крестиком,
// 2 – это поле с ноликом, 3 – резервное значение. Такое предположение позволит хранить в одном числе типа int
// всё поле 3х3. Записать в файл 9 значений так, чтобы они заняли три байта.

public class Task2 {
    public static void main(String[] args) {
        int[] state = {3, 1, 3, 0, 1, 2, 0, 2, 1};
        String fileName = "tick-tack-toe";

        try {
            saveState(state, fileName);

            System.out.println("\nThe size of '" + fileName + "' file is: "
                    + Files.size(Paths.get(fileName)) + " bytes");

            int[] arrRead = readState(fileName);
            System.out.print("\nCheck state written & read: ");
            Arrays.stream(arrRead).forEach(System.out::print);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void saveState(int[] state, String fileName) throws FileNotFoundException, IOException {

        File file = new File(fileName);
        byte[] toWrite = new byte[3];

        for (int i = 0; i < 3; i++) {
            toWrite[i] = convert4To10(state[i * 3], state[i * 3 + 1], state[i * 3 + 2]);
        }

        System.out.print("\nWriting tick-tack-toe state ... ");

        FileOutputStream outFile = new FileOutputStream(file);
        outFile.write(toWrite);
        outFile.close();

        System.out.println("done!");

    }

    public static int[] readState(String fileName) throws FileNotFoundException, IOException {
        int[] res = new int[9];
        byte[] toRead = new byte[3];

        FileInputStream inFile = new FileInputStream(fileName);
        int bytesAvailable = inFile.available();
        if (bytesAvailable == 3) {

            System.out.print("\nReading tick-tack-toe state ... ");
            int cnt = inFile.read(toRead, 0, bytesAvailable);
            for (int i = 0; i < cnt; i++) {
                int[] arr = convert10To4(toRead[i]);
                for (int j = 0; j < 3; j++) {
                    res[i * 3 + j] = arr[j];
                }
            }
            System.out.println("done!");

        } else {
            System.out.println("Check file format, does not match expected size! - " + bytesAvailable + " bytes.");
        }

        return res;
    }

    public static Byte convert4To10(int val1, int val2, int val3) {
        return (byte) (val1 * 16 + val2 * 4 + val3);
    }

    public static int[] convert10To4(int value) {
        int[] arr = new int[3];
        int res = value;
        int cnt = 0;
        while (res > 0) {
            arr[3 - cnt -1] = res % 4;
            res /= 4;
            cnt++;
        }
        return arr;
    }

}
