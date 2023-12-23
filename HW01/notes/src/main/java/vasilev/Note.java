package main.java.vasilev;

import java.util.Scanner;

public class Note {
    public static String getNote(String msg) {
        System.out.print(msg);
        String input = "";

        Scanner scanInput = new Scanner(System.in);
        if(scanInput.hasNextLine()) input = scanInput.nextLine();

        return input.isEmpty() ? "Empty message line..." : input;
    }
}
