package dushenin.oleksii.microservices.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import static dushenin.oleksii.microservices.zuul.filter.CorrelationIdUtils.*;

@Slf4j
@Component
public class BeforeCallFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        if (!getCorrelationId().isPresent()) {
            setCorrelationId(generateCorrelationId());
        }

        try {
            MDC.put(CORRELATION_ID, getCorrelationId().get());
            final RequestContext context = RequestContext.getCurrentContext();
            log.info("Processing incoming request for {}.", context.getRequest().getRequestURI());
            return null;
        } finally {
            MDC.clear();
        }

    }

}
