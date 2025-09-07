package mira.space.oms.services.product;

import mira.space.oms.data.model.product.Order;

public interface OrderService {

    Order findOrderById(Long id);
}
