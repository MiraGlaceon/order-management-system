package mira.space.oms.data.repository.crm;

import mira.space.oms.config.AuditorConfig;
import mira.space.oms.data.model.crm.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ContextConfiguration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

@ContextConfiguration(classes = {AuditorConfig.class})
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryIntegrationTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    private User user;

    @BeforeEach
    public void beforeEach() {
        user = new User();
        user.setLogin("mira");
        user.setPassword("12345");
        user.setNickname("Mira");
        user.setEmail("test@email.com");
    }

    @Test
    public void givenUserCreated_whenSave_thenSuccess() {
        User savedUser = userRepository.save(user);
        assertThat(testEntityManager.find(User.class, savedUser.getId()), equalTo(user));
    }

    @Test
    public void givenSavedUser_whenLoad_thenSuccess() {
        User savedUser = testEntityManager.persist(user);
        Assertions.assertThat(userRepository.findById(savedUser.getId())).hasValue(user);
    }
}
