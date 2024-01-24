package org.example;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

// Задание №1.
// Написать функцию, создающую резервную копию всех файлов в директории (без поддиректорий) во вновь созданную папку ./backup
public class Task1 {
    public static void main(String[] args) {
        String directory = ".";
        String backupDirName = "backup";

        try {
            backupFiles(directory, backupDirName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void backupFiles(String directory, String backupDirectoryName) throws IOException {
        File dir = new File(directory);
        File[] files = dir.listFiles();

        if (files != null) {
            List<File> filesListNotDir = Arrays.stream(files).filter(e -> !e.isDirectory()).toList();

            if (filesListNotDir.size() > 0) {
                Path backupPath = Paths.get(directory + "/" + backupDirectoryName);

                if (!Files.exists(backupPath)) Files.createDirectory(backupPath);
                for (File file : filesListNotDir) {
                    Files.copy(file.toPath(), Paths.get(directory + "/" + backupDirectoryName + "/" + file.getName()), REPLACE_EXISTING);
                }

                System.out.println("Backup succeeded, number of files saved: " + filesListNotDir.size());

            } else {
                System.out.println("No files to backup!");
            }
        }
    }

}