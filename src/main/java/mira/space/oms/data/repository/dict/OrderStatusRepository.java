package mira.space.oms.data.repository.dict;

import mira.space.oms.data.model.dict.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderStatusRepository extends JpaRepository<OrderStatus, Long> {

    Optional<OrderStatus> findOrderStatusByCode(String code);
}
