package dushenin.oleksii.microservices.zuul.filter;

import com.netflix.zuul.context.RequestContext;

import java.util.Optional;
import java.util.UUID;

public class CorrelationIdUtils {

    public static final String CORRELATION_ID = "correlation-id";

    public static Optional<String> getCorrelationId() {
        final RequestContext context = RequestContext.getCurrentContext();
        if (context.getRequest().getHeader(CORRELATION_ID) != null) {
            return Optional.of(context.getRequest().getHeader(CORRELATION_ID));
        }

        return Optional.ofNullable(context.getZuulRequestHeaders().get(CORRELATION_ID));
    }

    public static void setCorrelationId(String id) {
        RequestContext.getCurrentContext().addZuulRequestHeader(CORRELATION_ID, id);
    }

    public static String generateCorrelationId() {
        return UUID.randomUUID().toString();
    }

}
