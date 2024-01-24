package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

// Задание 5 (необязательное)
// Задача: Написать функцию, добавляющую префикс к каждому из набора
// файлов, названия которых переданы ей в качестве параметров через
// пробел.
public class Task5 {
    public static void main(String[] args) throws IOException {
        String prefix = "old_";
        String[] files = {"task3.txt", "file1.txt"};

        setPrefix(files, prefix);
    }

    public static void setPrefix(String[] paths, String prefix) throws IOException {
        for (String fname : paths) {
            Path file = Path.of(fname);
            if(Files.exists(file)){
                Files.move(file, Paths.get(prefix + fname), REPLACE_EXISTING);
            } else{
                System.out.println("File '" + fname + "' not found!");
            }
        }
    }
}
