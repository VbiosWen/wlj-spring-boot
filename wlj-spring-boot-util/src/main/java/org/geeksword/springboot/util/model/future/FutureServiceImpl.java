package org.geeksword.springboot.util.model.future;

import org.geeksword.springboot.util.pool.ThreadPoolUtil;

import java.util.Objects;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class FutureServiceImpl<IN, OUT> implements FutureService<IN, OUT> {

    private static final String NAME_THREAD_POOL = "FUTURE_THREAD_%d";

    private static final AtomicInteger COUNT = new AtomicInteger(0);

    private static final ThreadPoolExecutor THREAD_POOL_EXECUTOR = ThreadPoolUtil.createDefaultThreadPool();

    public static void main(String[] args) throws InterruptedException {
        FutureService<String, Integer> service = FutureService.newFuture();

        Future<Integer> future = service.submit(input -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return input.length();
        }, "Hello");
        System.out.println(future.get());
        if (!THREAD_POOL_EXECUTOR.isShutdown()) {
            TimeUnit.SECONDS.sleep(3);
            THREAD_POOL_EXECUTOR.shutdown();
        }
    }

    private String getNextName() {
        return String.format(NAME_THREAD_POOL, COUNT.getAndIncrement());
    }

    @Override
    public Future<?> submit(Runnable runnable) {
        final FutureTask<Void> futureTask = new FutureTask<>();
        THREAD_POOL_EXECUTOR.execute(() -> {
            runnable.run();
            futureTask.finish(null);
        });
        return futureTask;
    }

    @Override
    public Future<OUT> submit(Task<IN, OUT> task, IN input) {
        final FutureTask<OUT> futureTask = new FutureTask<>();
        THREAD_POOL_EXECUTOR.execute(() -> {
            OUT result = task.get(input);
            futureTask.finish(result);
        });
        return futureTask;
    }

    @Override
    public Future<OUT> submit(Task<IN, OUT> task, IN input, CallBack<OUT> callBack) {
        final FutureTask<OUT> futureTask = new FutureTask<>();
        THREAD_POOL_EXECUTOR.execute(() -> {
            OUT result = task.get(input);
            futureTask.finish(result);
            if (Objects.nonNull(callBack)) {
                callBack.call(result);
            }
        });
        return futureTask;
    }
}
