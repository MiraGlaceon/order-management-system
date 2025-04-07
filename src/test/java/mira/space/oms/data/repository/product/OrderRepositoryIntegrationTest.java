package mira.space.oms.data.repository.product;

import mira.space.oms.config.AuditorConfig;
import mira.space.oms.data.model.crm.User;
import mira.space.oms.data.model.dict.OrderStatus;
import mira.space.oms.data.model.product.Order;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ContextConfiguration;

import java.math.BigDecimal;

@ContextConfiguration(classes = {AuditorConfig.class})
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class OrderRepositoryIntegrationTest {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private TestEntityManager testEntityManager;

    private Order order;

    @BeforeEach
    public void beforeEach() {
        User user = new User();
        user.setLogin("mira");
        user.setPassword("12345");
        user.setNickname("Mira");
        user.setEmail("test@email.com");
        User savedUser = testEntityManager.persist(user);
        OrderStatus orderStatusCreated = testEntityManager.find(OrderStatus.class, 1);
        order = new Order();
        order.setUser(savedUser);
        order.setOrderStatus(orderStatusCreated);
        order.setOrderNumber(1000);
        order.setTotalPrice(new BigDecimal(10000));
    }

    @Test
    public void givenCreatedOrder_whenSave_thenSuccess() {
        Order savedOrder = orderRepository.save(order);
        Assertions.assertThat(testEntityManager.find(Order.class, savedOrder.getId())).isEqualTo(order);
    }

    @Test
    public void givenSavedOrder_whenLoad_thenSuccess() {
        Order savedOrder = testEntityManager.persist(order);
        Assertions.assertThat(orderRepository.findById(savedOrder.getId())).contains(order);
    }
}
