package lineorders.service;

import lineorders.command.CreateOrderCommand;
import lineorders.command.ShippingCommand;
import lineorders.entity.Order;
import lineorders.entity.OrderDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class OrderService {

    private final List<Order> orders = new ArrayList<>();

    private AtomicLong idGenerator = new AtomicLong();

    private final ModelMapper modelMapper;

    public OrderService(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }


    public List<OrderDTO> listOrders(Optional<Integer> month) {
        return orders.stream()
                .filter(order -> month.isEmpty() || order.getOrderDate().getYear() == LocalDate.now().getYear())
                .filter(order -> month.isEmpty() || order.getOrderDate().getMonth().getValue() == month.get())
                .map(order -> modelMapper.map(order, OrderDTO.class))
                .toList();
    }

    public OrderDTO findOrderById(Long id) {
        return modelMapper.map(findById(id), OrderDTO.class);
    }

    public OrderDTO createOrder(CreateOrderCommand command) {
        Order result = new Order(idGenerator.incrementAndGet(), command.getProductNumber(), LocalDate.now());
        orders.add(result);

        return modelMapper.map(result, OrderDTO.class);
    }

    public OrderDTO updateOrderById(Long id, ShippingCommand command) {
        Order result = findById(id);
        if (result.getShippingDate() != null) {
            throw new IllegalStateException("Cannot update date of delivery");
        }
        result.setShippingDate(LocalDate.now());
        result.setShippingPrice(command.getPrice());
        return modelMapper.map(result, OrderDTO.class);
    }

    public int getShippingIncome() {
        return orders.stream()
                .map(Order::getShippingPrice)
                .reduce(0, Integer::sum, Integer::sum);
    }

    public void deleteAll() {
        idGenerator = new AtomicLong();
        orders.clear();
    }

    private Order findById(Long id) {
        return orders.stream()
                .filter(order -> order.getId().equals(id))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("Cannot find id: " + id));
    }
}
