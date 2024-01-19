package task2;

import lombok.AllArgsConstructor;
import task2.exceptions.AmountException;
import task2.exceptions.CustomerException;
import task2.exceptions.ProductException;

import java.util.ArrayList;
import java.util.Arrays;

//Семинар №4. Задание 2
//        Задача: Эмуляция интернет-магазина
//        1. написать классы покупатель, товар и заказ;
//        2. создать массив покупателей, массив товаров и массив заказов;
//        3. создать статический метод “совершить покупку” со строковыми
//        параметрами, соответствующими полям объекта заказа. Метод
//        должен вернуть объект заказа
//        4. Если в метод передан несуществующий покупатель, товар или
//        отрицательное количество, метод должен выбросить
//        соответствующее исключение;
//        5. Вызвать метод совершения покупки несколько раз таким образом,
//        чтобы заполнить массив покупок возвращаемыми значениями.
//        Обработать исключения.
//        6. Вывести в консоль итоговое количество совершённых покупок после
//        выполнения приложения.
public class Main {

    public static void main(String[] args) {

        try {

            Store.customers = new ArrayList<>(Arrays.asList(
                    new Customer("Семён", 30, "1111111", Customer.Gender.MALE),
                    new Customer("Наталья", 25, "22222222", Customer.Gender.FEMALE),
                    new Customer("Иван", 45, "33333333", Customer.Gender.MALE),
                    new Customer("Татьяна", 35, "44444444", Customer.Gender.FEMALE),
                    new Customer("Ольга", 20, "55555555", Customer.Gender.FEMALE)
            ));

            Store.products = new ArrayList<>(Arrays.asList(
                    new Product("Конструктор", 5000),
                    new Product("Кукла", 2700),
                    new Product("Самокат", 4500)
            ));

            // testing fields values to make orders
            ArrayList<String> tryNames = new ArrayList<>(Arrays.asList("Семён", "Татьяна", "Василий", "Иван", "Семён", "Ольга"));
            ArrayList<String> tryProducts = new ArrayList<>(Arrays.asList("Самокат", "Кукла", "Конструктор", "Самокат", "Пазл", "Кукла"));
            ArrayList<Integer> tryQuantity = new ArrayList<>(Arrays.asList(1, 5, 1, 0, 1, 2));

            // making orders with exceptions depending on the reason
            System.out.println();
            for (int i = 0; i < tryNames.size(); i++) {

                try {
                    Store.orders.add(Store.makeNewOrder(tryNames.get(i), tryProducts.get(i), tryQuantity.get(i)));

                } catch (CustomerException e) {
                    System.out.println("Try order #" + (i + 1) + ": " + e.getMessage());
                } catch (ProductException e) {
                    System.out.println("Try order #" + (i + 1) + ": " + e.getMessage());
                } catch (AmountException e) {
                    System.out.println("Try order #" + (i + 1) + ": " + e.getMessage());
                }

            }

            System.out.println("\nКоличество заказов в магазине: " + Store.orders.size());
            System.out.println("Список заказов: ");
            Store.orders.stream().map(Order::toString).forEach(System.out::println);


            // HOMEWORK - Congratulations
            System.out.println("\nПоздравляем всех клиентов c Новым годом:");
            CongratulatingCustomers(Store.customers, "2023-01-01");

            System.out.println("\nПоздравляем мужчин с 23-м февраля:");
            CongratulatingCustomers(Store.customers, "2023-02-23");

            System.out.println("\nПоздравляем женщин с 8-м марта:");
            CongratulatingCustomers(Store.customers, "2023-03-08");

            System.out.println("\nНикого не поздравляем:");
            CongratulatingCustomers(Store.customers, "2023-05-03");


        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    // Домашнее задание №2. Добавить в основную программу перечисление с праздниками
    // (нет праздника, Новый Год, 8 марта, 23 февраля), написать метод, принимающий массив покупателей,
    // поздравляющий всех сотрудников с Новым Годом, женщин с 8 марта, а мужчин с 23 февраля, если сегодня соответствующий день.
    @AllArgsConstructor
    enum Holidays {
        NO_HOLIDAY("--", Customer.Gender.ANY, "")
        , NEW_YEAR("01-01", Customer.Gender.ANY, ", поздравляем с Новым Годом!!!")
        , MARCH_8("03-08", Customer.Gender.FEMALE, ", поздравляем с праздником 8 марта!!!")
        , FEBRUARY_23("02-23", Customer.Gender.MALE, ", поздравляем с Днем защитника Отечества!!!");
        private String date;
        private Customer.Gender gender;
        private String congratText;
    }

    /**
     * @param customers list of customers to look through
     * @param todayDate the date to check (normally today)
     * @apiNote congratulation of customers in the list on relevant holidays (New Year - all customers, 
     * 8th March - women only, 23rd February - men only
     * @see Main#CongratulatingCustomers(ArrayList, String) 
     */
    public static void CongratulatingCustomers(ArrayList<Customer> customers, String todayDate){

        for (Holidays item: Holidays.values()) {

            if(todayDate.contains(item.date)){
                if(item.gender == Customer.Gender.ANY){
                    customers.stream()
                            .map(e -> (e.getFio() + item.congratText))
                            .forEach(System.out::println);
                } else{
                    customers.stream()
                            .filter(e -> e.getGender()==item.gender)
                            .map(e -> (e.getFio() + item.congratText))
                            .forEach(System.out::println);
                }
            }
        }
    }

}