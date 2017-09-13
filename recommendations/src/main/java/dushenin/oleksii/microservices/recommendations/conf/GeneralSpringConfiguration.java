package dushenin.oleksii.microservices.recommendations.conf;

import dushenin.oleksii.microservices.common.web.ContextFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GeneralSpringConfiguration {

    @Bean
    public ContextFilter contextFilter() {
        return new ContextFilter();
    }

}
