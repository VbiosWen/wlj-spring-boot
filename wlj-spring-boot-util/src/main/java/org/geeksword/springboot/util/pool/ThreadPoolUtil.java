package org.geeksword.springboot.util.pool;

import java.lang.Thread.UncaughtExceptionHandler;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 7:06 PM 2019/1/6
 * @Modified By:
 */
public class ThreadPoolUtil {

    private static final int DEFAULT_INIT_THREAD_SIZE = 5;

    private static final int DEFAULT_MAX_THREAD_SIZE = 10;
    private static final TimeUnit DEFAULT_UNIT = TimeUnit.SECONDS;
    private static final long DEFAULT_KEEP_ALIVE_TIME = 0L;
    private static final String DEFAULT_THREAD_POOL_NAME = "DEFAULT-THREAD-POOL-";
    private final ThreadPoolExecutor executor;

    private ThreadPoolUtil() {
        LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue<>(
                DEFAULT_INIT_THREAD_SIZE * DEFAULT_MAX_THREAD_SIZE * 3 / 4);
        this.executor = new ThreadPoolExecutor(DEFAULT_INIT_THREAD_SIZE, DEFAULT_MAX_THREAD_SIZE,
                DEFAULT_KEEP_ALIVE_TIME, DEFAULT_UNIT, queue, new ThreadFactory() {
            private AtomicInteger atomicInteger = new AtomicInteger(0);

            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r, DEFAULT_THREAD_POOL_NAME + atomicInteger.incrementAndGet());
                thread.setUncaughtExceptionHandler(new ThreadExceptionHandler());
                thread.setDaemon(Boolean.FALSE);
                return thread;
            }
        });
    }

    private ThreadPoolUtil(int initThreadSize, int maxThreadSize, TimeUnit timeUnit,
                           long keepAliveTime, String threadName, int waitQueueSize, RejectedExecutionHandler handler) {

        LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue<>(waitQueueSize);
        this.executor = new ThreadPoolExecutor(initThreadSize, maxThreadSize, keepAliveTime, timeUnit,
                queue, new ThreadFactory() {
            private AtomicInteger atomicInteger = new AtomicInteger();

            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, threadName + "-" + atomicInteger.incrementAndGet());
            }
        }, handler);
    }


    public static ThreadPoolExecutor createDefaultThreadPool() {
        return new ThreadPoolUtil().executor;
    }

    public static ThreadPoolExecutor createCustomizeThreadPool(int initThreadSize, int maxThreadSize,
                                                               TimeUnit timeUnit, long keepAliveTime, String threadName, int waitQueueSize,
                                                               RejectedExecutionHandler handler) {
        return new ThreadPoolUtil(initThreadSize, maxThreadSize, timeUnit, keepAliveTime, threadName,
                waitQueueSize, handler).executor;
    }

    public static void main(String[] args) {
        ThreadPoolExecutor defaultThreadPool = createDefaultThreadPool();
        ThreadPoolExecutor test = createCustomizeThreadPool(DEFAULT_INIT_THREAD_SIZE,
                DEFAULT_MAX_THREAD_SIZE,
                TimeUnit.SECONDS, 1L, "test",
                10, (r, executor1) -> {
                    try {
                        executor1.getQueue().put(r);
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                });
        defaultThreadPool.execute(() -> System.out.println("test"));
        defaultThreadPool.shutdown();
        test.execute(() -> System.out.println("hello world"));
        if (test.getQueue().size() == 0) {
            test.shutdown();
        }
    }

    private class ThreadExceptionHandler implements UncaughtExceptionHandler {

        @Override
        public void uncaughtException(Thread t, Throwable e) {
            System.out.printf("%s throw an throwable" + e, t.getName());
        }
    }


}
