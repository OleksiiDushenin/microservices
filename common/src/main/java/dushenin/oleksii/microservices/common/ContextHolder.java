package dushenin.oleksii.microservices.common;

import java.util.Optional;

public class ContextHolder {

    public static final String CORRELATION_ID = "correlation-id";
    private static final ThreadLocal<Context> CONTEXT = new ThreadLocal<>();

    public static void setContext(Context context) {
        CONTEXT.set(context);
    }

    public static Optional<Context> getContext() {
        return Optional.ofNullable(CONTEXT.get());
    }
}
