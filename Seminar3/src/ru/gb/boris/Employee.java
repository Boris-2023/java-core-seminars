package ru.gb.boris;

// Задание 1
// Задача: Создать класс ”Сотрудник” с полями: ФИО, должность, телефон,
// зарплата, возраст;
public class Employee {

    private final int CURRENT_YEAR = 2024;
    private String name;
    private String position;
    private String phone;
    private double salary;
    private int birthYear;

    public Employee(String name, String position, String phone, double salary, int birthYear) {
        this.name = name;
        this.position = position;
        this.phone = phone;
        this.salary = salary;
        this.birthYear = birthYear;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public int getAge() {
        return CURRENT_YEAR - birthYear;
    }

    public void setBirthYear(int age) {
        this.birthYear = age;
    }


    public String toString() {
        return "Employee {" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", phone='" + phone + '\'' +
                ", salary=" + salary +
                ", age=" + getAge() +
                '}';
    }

    //    Задание 2
//    Задача: Написать функцию выводящую всю доступную информацию об
//    объекте
    public void printInfo() {
        System.out.println(this.toString());
    }

    //    Задание 2*
//    Задача: Написать функцию выводящую всю доступную информацию об объекте таким образом, чтобы функция
//    возвращала значение;
    public String printAndReturnInfo() {
        System.out.println(this.toString());
        return this.toString();
    }

    //    Задание 2**
//    Задача: Написать функцию выводящую всю доступную информацию об объекте с использованием форматирования
//    строк.
    public void printInfoFormatted() {
        System.out.println(String.format(
                "Employee [name = '%s', position = '%s', " +
                        "phone = '%s', salary = %.2f, age = %d]",
                name, position, phone, salary, getAge())
        );
    }

    public void increaseSalary(int amount) {
        this.salary += amount;
    }


//    Задание 4**
//    Задача: Написать метод повышения зарплаты в качестве статического в классе сотрудника.
    // ТАК ДЕЛАТЬ НЕ НАДО !!! ЛОГИКИ ТУТ ВАЩЕ БЫТЬ НЕ ДОЖНО
    public static void increaseSalary(Employee[] staff, int minAge, int amountToAdd) {
        for (int i = 0; i < staff.length; i++) {
            if (staff[i].getAge() >= minAge) staff[i].increaseSalary(amountToAdd);
        }
    }

}
