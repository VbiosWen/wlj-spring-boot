package org.geeksword.springboot.util.model;

import org.geeksword.springboot.util.pool.ThreadPoolUtil;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class InvokerPool {

    private static final ThreadPoolExecutor POOL_EXECUTOR = ThreadPoolUtil.createCustomizeThreadPool(100, 200, TimeUnit.SECONDS, 10L, "INVOKER", 100, new ThreadPoolExecutor.CallerRunsPolicy());


    private static class InvokerTask implements Runnable {

        private final Invoker invoker;

        public InvokerTask(Invoker invoker) {
            this.invoker = invoker;
        }

        @Override
        public void run() {
            this.invoker.call();
        }
    }

    public static void asyncExecute(Invoker invoker) {
        POOL_EXECUTOR.execute(new InvokerTask(invoker));
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            asyncExecute(new ConcreteInvoker(new ConcreteCommand(() -> System.out.println("Hello World."))));
        }
    }

}
