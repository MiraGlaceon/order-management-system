package mira.space.oms.services.product.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import mira.space.oms.data.model.product.Order;
import mira.space.oms.data.repository.product.OrderRepository;
import mira.space.oms.services.product.OrderService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public Order findOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Order by id = " + id + ", not found"));
    }
}
