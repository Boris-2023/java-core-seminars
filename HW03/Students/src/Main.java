import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

// Задание №3
//   Имеется список студентов. Каждый студент имеет имя, список оценок и специальность.
//   Найдите первых 5 студентов специальности "Информатика" с средним баллом выше 4.5, отсортированных по убыванию среднего балла.
//   В решении не использовать циклы! Только StreamAPI
public class Main {
    public static void main(String[] args) {

        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Ваня Ванин", new ArrayList<>(Arrays.asList(5D, 3D, 4D, 4D, 5D, 3D, 4D, 5D)), "Информатика"));
        students.add(new Student("Вася Васин", new ArrayList<>(Arrays.asList(5D, 5D, 4D, 4D, 5D, 5D, 4D, 5D, 5D)), "Информатика"));
        students.add(new Student("Света Светова", new ArrayList<>(Arrays.asList(4D, 5D, 5D, 5D, 5D, 4D, 5D, 5D)), "История"));
        students.add(new Student("Катя Катина", new ArrayList<>(Arrays.asList(3D, 3D, 4D, 5D, 3D, 4D, 3D)), "Информатика"));
        students.add(new Student("Паша Пашин", new ArrayList<>(Arrays.asList(5D, 3D, 4D, 4D, 5D, 5D, 4D, 5D, 4D, 4D)), "История"));
        students.add(new Student("Семен Семенов", new ArrayList<>(Arrays.asList(3D, 3D, 4D, 4D, 4D, 5D, 5D)), "Информатика"));
        students.add(new Student("Лена Ленина", new ArrayList<>(Arrays.asList(4D, 5D, 5D, 5D, 5D, 4D, 5D, 5D)), "История"));
        students.add(new Student("Таня Танина", new ArrayList<>(Arrays.asList(5D, 5D, 4D, 4D, 4D, 5D, 5D)), "Информатика"));
        students.add(new Student("Сеня Сенин", new ArrayList<>(Arrays.asList(4D, 5D, 5D, 5D, 5D, 5D, 5D)), "Информатика"));
        students.add(new Student("Соня Сонина", new ArrayList<>(Arrays.asList(5D, 4D, 4D, 5D, 5D)), "Информатика"));
        students.add(new Student("Рома Ромин", new ArrayList<>(Arrays.asList(4D, 5D, 5D, 5D, 5D, 4D, 5D, 5D)), "Информатика"));

        printStudents(students);


//   Найдите первых 5 студентов специальности "Информатика" с средним баллом выше 4.5, отсортированных по убыванию среднего балла.
//   В решении не использовать циклы! Только StreamAPI
        System.out.println("\n5 лучших студентов (средний бал >= 4.5; специальность \"Информатика\":");
        students
                .stream()
                .filter(e -> e.getSpecialty().equals("Информатика") && e.getAverageGrade() >= 4.5)
//                .filter(e -> e.getAverageGrade() >= 4.5)
                .sorted(Comparator.comparing(Student::getAverageGrade).reversed())
                .map(Student::toString)
                .limit(5)
                .forEach(System.out::println);

    }

    public static void printStudents(ArrayList<Student> studs) {
        studs.stream().map(Student::toString).forEach(System.out::println);
    }
}