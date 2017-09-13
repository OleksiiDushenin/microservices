package dushenin.oleksii.microservices.movies.conf.hystrix;

import dushenin.oleksii.microservices.common.Context;
import dushenin.oleksii.microservices.common.ContextHolder;
import lombok.AllArgsConstructor;

import java.util.concurrent.Callable;

@AllArgsConstructor
public class ContextCallable<T> implements Callable<T> {
    private final Callable<T> delegate;
    private final Context context;

    @Override
    public T call() throws Exception {
        ContextHolder.setContext(context);
        try {
            return delegate.call();
        } finally {
            ContextHolder.setContext(null);
        }
    }

}
