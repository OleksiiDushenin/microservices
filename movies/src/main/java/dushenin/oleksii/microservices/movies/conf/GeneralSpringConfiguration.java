package dushenin.oleksii.microservices.movies.conf;

import dushenin.oleksii.microservices.common.web.ContextFilter;
import dushenin.oleksii.microservices.movies.conf.web.ContextInterceptor;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class GeneralSpringConfiguration {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        final RestTemplate restTemplate = new RestTemplate();
        restTemplate.getInterceptors().add(new ContextInterceptor());
        return restTemplate;
    }

    @Bean
    public ContextFilter contextFilter() {
        return new ContextFilter();
    }

}
