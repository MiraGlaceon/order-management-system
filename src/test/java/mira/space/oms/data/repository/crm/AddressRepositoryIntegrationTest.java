package mira.space.oms.data.repository.crm;

import mira.space.oms.config.AuditorConfig;
import mira.space.oms.data.model.crm.Address;
import mira.space.oms.data.model.crm.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = {AuditorConfig.class})
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AddressRepositoryIntegrationTest {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    private Address address;

    @BeforeEach
    public void beforeEach() {
        User user = new User();
        user.setLogin("mira");
        user.setPassword("12345");
        user.setNickname("Mira");
        user.setEmail("test@email.com");
        User savedUser = testEntityManager.persist(user);
        address = new Address();
        address.setCity("city");
        address.setStreet("street");
        address.setHouse("house");
        address.setFullAddress("full address");
        address.setUser(savedUser);
    }

    @Test
    public void givenAddressCreated_whenSave_thenSuccess() {
        Address savedAddress = addressRepository.save(address);
        Assertions.assertThat(testEntityManager.find(Address.class, savedAddress.getId())).isEqualTo(address);
    }

}
