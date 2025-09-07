package mira.space.oms.controllers.product;

import lombok.AllArgsConstructor;
import mira.space.oms.data.model.product.Order;
import mira.space.oms.services.product.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/orders")
@AllArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id) {
        return orderService.findOrderById(id);
    }

}
