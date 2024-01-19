package task2;

import task2.exceptions.AmountException;
import task2.exceptions.CustomerException;
import task2.exceptions.ProductException;

import java.util.ArrayList;
import java.util.Arrays;

//Задание 2
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
                    new Customer("Семён", 30, "1111111"),
                    new Customer("Наталья", 25, "22222222"),
                    new Customer("Иван", 45, "33333333"),
                    new Customer("Татьяна", 35, "44444444"),
                    new Customer("Ольга", 20, "55555555")
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

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}