
public class Employee {

    protected static int id = 0;
    private final int CURRENT_YEAR = 2024;
    private String name;
    private String position;
    private String phone;
    private double salary;
    private int birthYear;


    private int uid;

    public Employee(String name, String position, String phone, double salary, int birthYear) {
        this.name = name;
        this.position = position;
        this.phone = phone;
        this.salary = salary;
        this.birthYear = birthYear;
        uid = ++id;
    }

    public int getUid() {
        return uid;
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
        return "Employee ID #" + uid + " {" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", phone='" + phone + '\'' +
                ", salary=" + salary +
                ", age=" + getAge() +
                '}';
    }

    public void increaseSalary(int amount) {
        this.salary += amount;
    }

    //    Задание 1
    //    Написать прототип компаратора - метод внутри класса сотрудника, сравнивающий две даты,
    //    представленные в виде трёх чисел гггг-мм-дд, без использования условного оператора.
    public int compareDates(int[] date1, int[] date2) {
        int d1 = date1[0] * 10000 + date1[1] * 100 + date1[2];
        int d2 = date2[0] * 10000 + date2[1] * 100 + date2[2];

        int diff = d1 - d2;

        try {
            return -diff / Math.abs(diff);
        } catch (Exception e) {
            return 0;
        }
    }

}
