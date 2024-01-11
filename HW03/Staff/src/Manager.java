//    Задание 2
// Опишите класс руководителя, наследник от сотрудника. Перенесите статический метод повышения зарплаты в класс руководителя,
// модифицируйте метод таким образом, чтобы он мог поднять заработную плату всем, кроме руководителей.
// В основной программе создайте руководителя и поместите его в общий массив сотрудников.
// Повысьте зарплату всем сотрудникам и проследите, чтобы зарплата руководителя не повысилась.
public class Manager extends Employee {
    public Manager(String name, String position, String phone, double salary, int birthYear) {
        super(name, position, phone, salary, birthYear);
    }

    /**
     * @param staff            array of the employees
     * @param minAge           minimum age to apply salary increase
     * @param isManagerSkipped if the managers are skipped on salary increase
     * @param amountToAdd      amount the salary should be risen by
     * @apiNote increasing of salary by certain amount to all staff members older than preset age with an option not to
     * increase for the managers
     * @see Manager#increaseSalary(Employee[], int, boolean, int)
     */
    public static void increaseSalary(Employee[] staff, int minAge, boolean isManagerSkipped, int amountToAdd) {
        for (int i = 0; i < staff.length; i++) {
            if (staff[i].getAge() >= minAge
                    && (!isManagerSkipped || !(staff[i] instanceof Manager)))
                staff[i].increaseSalary(amountToAdd);
        }
    }
}
