package main.java.vasilev;

import java.io.FileWriter;
import java.io.IOException;

public class FileIO {

    String fileName;

    public FileIO(String fileName) {
        this.fileName = fileName;
    }

    public void addLine(String stringToAdd) {
        try {
            FileWriter fw = new FileWriter(fileName, true);
            fw.write(stringToAdd + "\n");

            System.out.println("Note '" + stringToAdd +
                    "' successfully added to file '" + fileName + "'!");

            fw.close();
        } catch (IOException ioe) {
            System.err.println("IOException: " + ioe.getMessage());
        }
    }

}
