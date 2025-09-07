package mira.space.oms.data.repository.product;

import mira.space.oms.data.model.product.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("""
            select e from oms_Order e
                join fetch e.orderStatus
                join fetch e.user
                where e.id = :id
            """)
    Optional<Order> findById(Long id);
}
