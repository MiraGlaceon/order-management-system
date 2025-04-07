package mira.space.oms.data.repository.product;

import mira.space.oms.config.AuditorConfig;
import mira.space.oms.data.model.product.Product;
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
public class ProductRepositoryIntegrationTest {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private TestEntityManager testEntityManager;

    private Product product;

    @BeforeEach
    public void beforeEach() {
        product = new Product();
        product.setName("name");
        product.setPrice(new BigDecimal(500));
        product.setAvailableQuantity(100);
    }

    @Test
    public void givenSavedProduct_whenLoad_thenSuccess() {
        Product savedProduct = testEntityManager.persist(product);
        Assertions.assertThat(productRepository.findById(savedProduct.getId())).isPresent();
    }
}
