import java.util.List;

public class Student {

    static int id = 0;
    private String name;
    private List<Double> grades;


    private String specialty;

    private int uid;

    public Student(String name, List<Double> grades, String specialty) {
        this.name = name;
        this.grades = grades;
        this.specialty = specialty;
        uid = ++id;
    }

    public String getSpecialty() {
        return specialty;
    }

    @Override
    public String toString() {
        return "Student ID #" + uid + " {" +
                "name= '" + name + '\'' +
                ", grades= " + grades +
                ", specialty= '" + specialty + '\'' +
                ", Average Grade= " + String.format("%.2f", getAverageGrade()) +
                '}';
    }

    public double getAverageGrade() {
        return grades
                .stream()
                .mapToDouble(e -> e)
                .average()
                .orElse(-1D);
    }

}
