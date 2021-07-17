package lineorders.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    private Long id;

    private String productNumber;

    private LocalDate orderDate;

    private int shippingPrice;

    private LocalDate shippingDate;

    public Order(Long id, String productNumber, LocalDate orderDate) {
        this.id = id;
        this.productNumber = productNumber;
        this.orderDate = orderDate;
    }
}
