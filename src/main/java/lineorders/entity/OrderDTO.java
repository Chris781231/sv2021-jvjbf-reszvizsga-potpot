package lineorders.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {

    private String productNumber;

    private LocalDate orderDate;

    private int shippingPrice;

    private LocalDate shippingDate;
}
