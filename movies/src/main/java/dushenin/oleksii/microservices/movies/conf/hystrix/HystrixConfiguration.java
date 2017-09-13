package dushenin.oleksii.microservices.movies.conf.hystrix;

import com.netflix.hystrix.strategy.HystrixPlugins;
import com.netflix.hystrix.strategy.concurrency.HystrixConcurrencyStrategy;
import com.netflix.hystrix.strategy.eventnotifier.HystrixEventNotifier;
import com.netflix.hystrix.strategy.executionhook.HystrixCommandExecutionHook;
import com.netflix.hystrix.strategy.metrics.HystrixMetricsPublisher;
import com.netflix.hystrix.strategy.properties.HystrixPropertiesStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class HystrixConfiguration {
    private final HystrixConcurrencyStrategy delegate;

    @Autowired(required = false)
    public HystrixConfiguration(HystrixConcurrencyStrategy delegate) {
        this.delegate = delegate;
    }

    @PostConstruct
    public void init() {
        final HystrixPlugins hystrixPlugins = HystrixPlugins.getInstance();
        final HystrixEventNotifier eventNotifier = hystrixPlugins.getEventNotifier();
        final HystrixMetricsPublisher metricsPublisher = hystrixPlugins.getMetricsPublisher();
        final HystrixPropertiesStrategy propertiesStrategy = hystrixPlugins.getPropertiesStrategy();
        final HystrixCommandExecutionHook commandExecutionHook = hystrixPlugins.getCommandExecutionHook();

        HystrixPlugins.reset();

        hystrixPlugins.registerConcurrencyStrategy(new ContextStrategy(delegate));
        hystrixPlugins.registerEventNotifier(eventNotifier);
        hystrixPlugins.registerMetricsPublisher(metricsPublisher);
        hystrixPlugins.registerPropertiesStrategy(propertiesStrategy);
        hystrixPlugins.registerCommandExecutionHook(commandExecutionHook);
    }

}
