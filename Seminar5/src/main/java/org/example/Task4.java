package org.example;

import java.io.File;
import java.util.Arrays;

// Задание 4
// Задача: Написать программу, читающую и
// выводящую в содержимое текущей папки .
public class Task4 {
    public static void main(String[] args) {
        dirContent(".", 0);
    }

    private static void dirContent(String dirName, int level) {
        File dir = new File(dirName);
        File[] files = dir.listFiles();

        for (File file : files) {
            String lvl = "";
            for (int i = 0; i < level; i++) {
                lvl += "   ";
            }
            if (file.isDirectory()) {
                System.out.println(lvl + file.getName() + "/");
                dirContent(file.getPath(), level + 1);
            } else {
                System.out.println(lvl + file.getName());

            }
        }
//        assert files != null;
//        Arrays.stream(files)
//                .map(File::getName)
//                .forEach(System.out::println);
    }


}
