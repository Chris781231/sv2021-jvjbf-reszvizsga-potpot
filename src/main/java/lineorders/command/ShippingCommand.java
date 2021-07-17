package lineorders.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Positive;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShippingCommand {

    @Positive
    private int price;
}
