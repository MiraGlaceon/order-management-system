package mira.space.oms.data.repository.dict;

import mira.space.oms.config.AuditorConfig;
import mira.space.oms.data.model.dict.OrderStatus;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.Optional;

@ContextConfiguration(classes = {AuditorConfig.class})
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class OrderStatusRepositoryIntegrationTest {

    @Autowired
    private OrderStatusRepository orderStatusRepository;

    @Test
    public void givenOrderStatusCode_whenLoad_thenSuccess() {
        String code = "CREATED";
        Optional<OrderStatus> orderStatusOptional = orderStatusRepository.findOrderStatusByCode(code);
        Assertions.assertThat(orderStatusOptional).isPresent();
    }
}
