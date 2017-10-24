package dushenin.oleksii.microservices.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AfterCallFilter extends ZuulFilter {

    public static final String CORRELATION_ID = "correlation-id";

    @Autowired
    private Tracer tracer;

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
        final RequestContext context = RequestContext.getCurrentContext();
        context.getResponse().addHeader(CORRELATION_ID, tracer.getCurrentSpan().traceIdString());
        log.info("Processing outcoming request for {}.", context.getRequest().getRequestURI());
        return null;
    }

}
