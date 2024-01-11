package ru.gb.boris;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

//        Задание 3
//        Задача: Создать массив из 5 сотрудников
        Employee ivan = new Employee("Ivan Ivanov", "tester", "8(495)000-11-22",
                50000, 1995);
        Employee natalia = new Employee("Nathalia Ivanova", "developer", "8(495)000-22-33",
                80000, 1990);
        Employee petr = new Employee("Petr Petrov", "senior developer", "8(495)000-33-44",
                120000, 1975);
        Employee tatiana = new Employee("Tatiana Petrova", "accountant", "8(495)000-44-55",
                100000, 1979);
        Employee semen = new Employee("Semen Semenov", "sales agent", "8(495)000-55-66",
                60000, 1998);

        Employee[] staff = new Employee[5];
        staff[0] = ivan;
        staff[1] = natalia;
        staff[2] = petr;
        staff[3] = tatiana;
        staff[4] = semen;

//        Задание 3*
//        Задача: Создать массив из 5 сотрудников. Массив должен быть сразу инициализирован;
        Employee[] staff1 = new Employee[]{ivan, natalia, petr, tatiana, semen};

//        Задание 3**
//        Задача: Создать массив из 5 сотрудников. Массив должен быть сразу инициализирован и не должно быть создано
//        дополнительных переменных.
        Employee[] staff2 = new Employee[]{
                new Employee("Ivan Ivanov", "junior developer", "8(495)000-11-22",
                        50000, 1995),
                new Employee("Nathalia Ivanova", "middle developer", "8(495)000-22-33",
                        80000, 1990),
                new Employee("Petr Petrov", "senior developer", "8(495)000-33-44",
                        120000, 1975),
                new Employee("Tatiana Petrova", "accountant", "8(495)000-44-55",
                        100000, 1979),
                new Employee("Semen Semenov", "sales agent", "8(495)000-55-66",
                        60000, 1998)
        };

//    Задание 4
//    Задача: Создать метод, повышающий
//    зарплату всем сотрудникам старше 45 лет на
//    5000. Метод должен принимать в качестве
//    параметра массив сотрудников.
        for (int i = 0; i < staff.length; i++) {
            staff[i].printInfoFormatted();
        }
        //increaseSalary(staff, 45, 5000);
        Employee.increaseSalary(staff, 45, 5000);

        System.out.println();
        for (int i = 0; i < staff.length; i++) {
            staff[i].printInfoFormatted();
        }

        //    Задание 5 (необязательное)
//    Задача: Написать методы (принимающие на вход массив сотрудников),
//    вычисляющие средний возраст и среднюю зарплату сотрудников, вывести
//    результаты работы в консоль.
        System.out.println("\nСредний возраст:\t" + getAverageAge(staff) +
                "\nСредняя зарплата:\t" + getAverageSalary(staff));


        // --------> STREAM()
        System.out.println("\nСредний возраст:\t" +
                Arrays.stream(staff)
                        .mapToInt(Employee::getAge)
                        .filter(e -> e > 30)
                        .average()
                        .orElse(-1) +
                "\nСредняя зарплата:\t" +
                Arrays.asList(staff).stream()
                        .filter(e -> e.getAge() > 30)
                        .mapToDouble(Employee::getSalary)
                        .average()
                        .orElse(-1.0F));

// Получить список имен
        ArrayList<Employee> staffList = new ArrayList<>(Arrays.asList(staff));
//        List<String> names = staffList.stream()
        List<String> names = Arrays.stream(staff)
                .map(e -> {
                    String s = e.getName();
                    s = s.toUpperCase().replace('A', 'a');
                    return s;
                })
                .collect(Collectors.toList());
        System.out.println(names);

// max salary
        double max = Arrays.stream(staff).mapToDouble(Employee::getSalary).max().orElse(-1);
        double max2 = Arrays.stream(staff)
                .map(e -> e.getSalary())
                .max(Comparator.naturalOrder())
                .orElse(-1d);

        Optional<Double> max3 = staffList.stream()
                .map(e -> e.getSalary())
                .max(Comparator.naturalOrder());

        Double max4 = max3.get();


        System.out.println(max + " = " + max2 + " = " + max3 + " = " + max4);

        System.out.println(max3.map(e -> e + 10).get());

    }

    public static void increaseSalary(Employee[] staff, int minAge, int amountToAdd) {
        for (int i = 0; i < staff.length; i++) {
            if (staff[i].getAge() >= minAge) staff[i].increaseSalary(amountToAdd);
        }
    }

    //    Задание 5 (необязательное)
//    Задача: Написать методы (принимающие на вход массив сотрудников),
//    вычисляющие средний возраст и среднюю зарплату сотрудников, вывести
//    результаты работы в консоль.
    public static double getAverageAge(Employee[] staff) {
        double res = 0;
        for (int i = 0; i < staff.length; i++) {
            res += staff[i].getAge();
        }
        return res / staff.length;
    }

    public static double getAverageSalary(Employee[] staff) {
        double res = 0;
        for (int i = 0; i < staff.length; i++) {
            res += staff[i].getSalary();
        }
        return res / staff.length;
    }

}