package dushenin.oleksii.microservices.movies.conf.hystrix;

import com.netflix.hystrix.HystrixThreadPoolKey;
import com.netflix.hystrix.strategy.concurrency.HystrixConcurrencyStrategy;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestVariable;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestVariableLifecycle;
import com.netflix.hystrix.strategy.properties.HystrixProperty;
import lombok.AllArgsConstructor;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import static dushenin.oleksii.microservices.common.ContextHolder.getContext;

@AllArgsConstructor
public class ContextStrategy extends HystrixConcurrencyStrategy {
    private final HystrixConcurrencyStrategy delegate;

    @Override
    public BlockingQueue<Runnable> getBlockingQueue(int maxQueueSize) {
        return delegate != null
                ? delegate.getBlockingQueue(maxQueueSize)
                : super.getBlockingQueue(maxQueueSize);
    }

    @Override
    public <T> HystrixRequestVariable<T> getRequestVariable(HystrixRequestVariableLifecycle<T> rv) {
        return delegate != null
                ? delegate.getRequestVariable(rv)
                : super.getRequestVariable(rv);
    }

    @Override
    public ThreadPoolExecutor getThreadPool(HystrixThreadPoolKey threadPoolKey,
                                            HystrixProperty<Integer> corePoolSize,
                                            HystrixProperty<Integer> maximumPoolSize,
                                            HystrixProperty<Integer> keepAliveTime,
                                            TimeUnit unit,
                                            BlockingQueue<Runnable> workQueue) {
        return delegate != null
                ? delegate.getThreadPool(threadPoolKey, corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue)
                : super.getThreadPool(threadPoolKey, corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    @Override
    public <T> Callable<T> wrapCallable(Callable<T> callable) {
        return delegate != null
                ? delegate.wrapCallable(new ContextCallable<>(callable, getContext().orElseGet(null)))
                : super.wrapCallable(new ContextCallable<>(callable, getContext().orElseGet(null)));
    }
}
