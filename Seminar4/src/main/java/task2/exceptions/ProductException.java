package task2.exceptions;

public class ProductException extends RuntimeException {
    public ProductException(String productName) {

        super("No product '" + productName + "' in stock!");
    }
}
