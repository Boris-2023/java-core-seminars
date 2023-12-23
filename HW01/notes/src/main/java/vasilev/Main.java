package main.java.vasilev;

public class Main {
    public static void main(String[] args) {
        String fileName = "notes.txt";
        FileIO file = new FileIO(fileName);

        System.out.println(file.toString());

        String noteWithTime = TimeRoutine.getCurrentTime() +
                " -> " +
                Note.getNote("Your new note: ");

        file.addLine(noteWithTime);
    }
}
