package org.geeksword.springboot.util.model.future;

public interface FutureService<IN, OUT> {

    static <T, R> FutureService<T, R> newFuture() {
        return new FutureServiceImpl<>();
    }

    Future<?> submit(Runnable runnable);

    Future<OUT> submit(Task<IN, OUT> task, IN input);

    Future<OUT> submit(Task<IN, OUT> task, IN input, CallBack<OUT> callBack);
}
