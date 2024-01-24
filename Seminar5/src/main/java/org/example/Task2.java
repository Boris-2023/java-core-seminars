package org.example;

import java.io.*;
import java.util.ArrayList;

// Задание 2
// Задача: Создать массив целых чисел и заполнить его
// информацией из файла, записанного в предыдущем задании.
public class Task2 {
    public static void main(String[] args) {
        try {
            FileInputStream file = new FileInputStream("file.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(file));
            ArrayList<Integer> in = new ArrayList<>();

            String line = "";
            while((line = br.readLine()) != null){
                in.add(Integer.parseInt(line));
            }
            in.forEach(System.out::println);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
