package task2;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Order {
    private Customer customer;
    private Product product;
    private int quantity;
}
