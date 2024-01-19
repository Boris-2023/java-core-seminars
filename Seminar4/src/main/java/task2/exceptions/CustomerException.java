package task2.exceptions;

public class CustomerException extends RuntimeException {
    public CustomerException(String customerName) {
        super("No customer '"+ customerName + "' in the database!");
    }

}
