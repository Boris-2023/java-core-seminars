import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Employee[] staff = new Employee[]{
                new Employee("Ivan Ivanov", "tester", "8(495)000-11-22",
                        50000, 1995),
                new Employee("Petr Petrov", "developer", "8(495)000-33-44",
                        120000, 1975),
                new Employee("Tatiana Petrova", "accountant", "8(495)000-44-55",
                        100000, 1979),
                new Employee("Semen Semenov", "sales agent", "8(495)000-55-66",
                        60000, 1998),
                new Manager("Vasiliy Chapaev", "Director", "8(495)000-00-01",
                        300000, 1970)
        };

        //    Задание 1
        //    Написать прототип компаратора - метод внутри класса сотрудника, сравнивающий две даты,
        //    представленные в виде трёх чисел гггг-мм-дд, без использования условного оператора.

        int[] date1 = new int[]{2022, 11, 17};
        int[] date2 = new int[]{2022, 11, 17};

        System.out.println(
                "\nЗадание №1: " +
                "\n(даты последовательны -> 1; вторая раньше первой -> -1; даты одинаковы -> 0)" +
                "\nРезультат: " +
                staff[0].compareDates(date1, date2));

        //    Задание 2
        // Опишите класс руководителя, наследник от сотрудника. Перенесите статический метод повышения зарплаты в класс руководителя,
        // модифицируйте метод таким образом, чтобы он мог поднять заработную плату всем, кроме руководителей.
        // В основной программе создайте руководителя и поместите его в общий массив сотрудников.
        // Повысьте зарплату всем сотрудникам и проследите, чтобы зарплата руководителя не повысилась.
        System.out.println("\nЗадание №2:");
        printEmployees(staff);
        Manager.increaseSalary(staff, 45, true, 100);
        System.out.println("\nЗарплата повышена:");
        printEmployees(staff);

    }

    public static void printEmployees(Employee[] staff) {
        Arrays.asList(staff).stream().map(Employee::toString).forEach(System.out::println);
    }
}