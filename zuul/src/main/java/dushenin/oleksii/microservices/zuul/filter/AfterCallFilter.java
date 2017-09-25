package dushenin.oleksii.microservices.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import static dushenin.oleksii.microservices.zuul.filter.CorrelationIdUtils.CORRELATION_ID;
import static dushenin.oleksii.microservices.zuul.filter.CorrelationIdUtils.getCorrelationId;

@Slf4j
@Component
public class AfterCallFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return "post";
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
        try {
            final String correlationId = getCorrelationId().orElse(null);
            MDC.put(CORRELATION_ID, correlationId);
            final RequestContext context = RequestContext.getCurrentContext();
            context.getResponse().addHeader(CORRELATION_ID, correlationId);
            log.info("Processing outcoming request for {}.", context.getRequest().getRequestURI());
            return null;
        } finally {
            MDC.clear();
        }

    }

}
