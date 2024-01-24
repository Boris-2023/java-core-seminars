package org.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

// Задание 3
// Задача: Написать программу заменяющую указанный символ в
// текстовом файле на пробел, сохраняющую получившийся текст в
// новый файл.
public class Task3 {
    public static void main(String[] args) throws IOException {

        char what = 'e';
        char to = 'E';
        int ch;

        try {
            FileInputStream fis = new FileInputStream("task3.txt");
            FileOutputStream fos = new FileOutputStream("task3_new.txt");

            while ((ch = fis.read()) != -1) {
                if (ch == what) {
                    fos.write(to);
                } else {
                    fos.write(ch);
                }
            }
            fos.close();
            fis.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
