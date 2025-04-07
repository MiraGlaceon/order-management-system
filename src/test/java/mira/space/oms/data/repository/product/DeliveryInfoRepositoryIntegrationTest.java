package mira.space.oms.data.repository.product;

import mira.space.oms.config.AuditorConfig;
import mira.space.oms.data.model.crm.Address;
import mira.space.oms.data.model.crm.User;
import mira.space.oms.data.model.dict.OrderStatus;
import mira.space.oms.data.model.product.DeliveryInfo;
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
import java.time.LocalDateTime;

@ContextConfiguration(classes = {AuditorConfig.class})
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class DeliveryInfoRepositoryIntegrationTest {

    @Autowired
    private DeliveryInfoRepository deliveryInfoRepository;
    @Autowired
    private TestEntityManager testEntityManager;

    private DeliveryInfo deliveryInfo;

    @BeforeEach
    public void beforeEach() {
        User user = new User();
        user.setLogin("mira");
        user.setPassword("12345");
        user.setNickname("Mira");
        user.setEmail("test@email.com");
        User savedUser = testEntityManager.persist(user);
        OrderStatus orderStatusCreated = testEntityManager.find(OrderStatus.class, 1);
        Order order = new Order();
        order.setUser(savedUser);
        order.setOrderStatus(orderStatusCreated);
        order.setOrderNumber(1000);
        order.setTotalPrice(new BigDecimal(10000));
        Address address = new Address();
        address.setCity("city");
        address.setStreet("street");
        address.setHouse("house");
        address.setFullAddress("full address");
        address.setUser(savedUser);
        deliveryInfo = new DeliveryInfo();
        deliveryInfo.setOrder(order);
        deliveryInfo.setAddress(address);
        deliveryInfo.setEstimatedDate(LocalDateTime.now().plusHours(2));
    }

    @Test
    public void givenCreatedDeliveryInfo_whenLoad_thenSuccess() {
        DeliveryInfo savedDeliveryInfo = testEntityManager.persist(deliveryInfo);
        Assertions.assertThat(deliveryInfoRepository.findById(savedDeliveryInfo.getId())).contains(deliveryInfo);
    }

    @Test
    public void givenSavedDeliveryInfo_whenSave_thenSuccess() {
        DeliveryInfo savedDeliveryInfo = deliveryInfoRepository.save(deliveryInfo);
        Assertions.assertThat(testEntityManager.find(DeliveryInfo.class, savedDeliveryInfo.getId())).isEqualTo(deliveryInfo);
    }
}
