package mira.space.oms.config;

import mira.space.oms.services.audit.AuditorAwareImpl;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;

@TestConfiguration
public class AuditorConfig {

    @Bean("oms_AuditorAwareImpl")
    public AuditorAware<String> getAuditorAwareImpl() {
        return new AuditorAwareImpl();
    }
}
