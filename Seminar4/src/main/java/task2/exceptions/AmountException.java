package task2.exceptions;

public class AmountException extends RuntimeException {
    public AmountException(int amount) {
        super("Product quantity (" + amount + ") is not a natural value!");
    }
}
