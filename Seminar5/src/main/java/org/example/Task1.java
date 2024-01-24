package org.example;

import java.io.*;
import java.util.List;

public class Task1 {
    //    Задание 1
//    Задача: Создать массив из 9 цифр и записать его в файл,
//    используя поток вывода.
//    * Удостовериться, что числа записаны не символами, а цифрами
    public static void main(String[] args) {
        int[] arr = {0, 18, 3, 15, 42, 34, 56, 7, 51};
        File file = new File("file.txt");

        try {
            PrintWriter pw = new PrintWriter(new FileOutputStream(file));

            for (int j : arr) {
//                pw.print(j + " ");
                pw.println(j);
            }
            pw.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}