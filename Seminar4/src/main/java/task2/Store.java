package task2;

import lombok.Data;
import task2.exceptions.AmountException;
import task2.exceptions.CustomerException;
import task2.exceptions.ProductException;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Data
public class Store {

    private static final int maxQuantity = 100;
    static ArrayList<Customer> customers = new ArrayList<>();
    static ArrayList<Product> products = new ArrayList<>();
    static ArrayList<Order> orders = new ArrayList<>();

    public static Order makeNewOrder(String customerName, String productName, int quantity)
            throws CustomerException, ProductException, AmountException {
        Order order = new Order();
        int index;

        // setting customer if exists in DB
        index = checkCustomerName(customerName);
        if (index != -1) {
            order.setCustomer(customers.get(index));
        } else {
            throw new CustomerException(customerName);
        }

        // setting product if exists in DB
        index = checkProductName(productName);
        if (index != -1) {
            order.setProduct(products.get(index));
        } else {
            throw new ProductException(productName);
        }

        // setting quantity if within the range
        if (quantity > 0 && quantity <= maxQuantity) {
            order.setQuantity(quantity);
        } else {
            throw new AmountException(quantity);
        }

        return order;
    }

    private static int checkCustomerName(String customerName) {

        return customers.stream()
                .map(Customer::getFio)
                .collect(Collectors.toList())
                .indexOf(customerName);
    }

    private static int checkProductName(String productName) {
        return products.stream()
                .map(Product::getName)
                .collect(Collectors.toList())
                .indexOf(productName);

    }

}
