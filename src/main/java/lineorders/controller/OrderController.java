package lineorders.controller;

import lineorders.command.CreateOrderCommand;
import lineorders.command.ShippingCommand;
import lineorders.entity.OrderDTO;
import lineorders.service.OrderService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @GetMapping
    public List<OrderDTO> listOrders(@RequestParam Optional<Integer> month) {
        return service.listOrders(month);
    }

    @GetMapping("/{id}")
    public OrderDTO findOrderById(@PathVariable Long id) {
        return service.findOrderById(id);
    }

    @GetMapping("/shippingIncome")
    public int getShippingIncome() {
        return service.getShippingIncome();
    }

    @PostMapping
    public OrderDTO createOrder(@RequestBody @Valid CreateOrderCommand command) {
        return service.createOrder(command);
    }

    @PutMapping("/{id}/shipping")
    public OrderDTO updateOrderById(@PathVariable Long id, @RequestBody @Valid ShippingCommand command) {
        return service.updateOrderById(id, command);
    }

    @DeleteMapping
    public void deleteAll() {
        service.deleteAll();
    }
}
