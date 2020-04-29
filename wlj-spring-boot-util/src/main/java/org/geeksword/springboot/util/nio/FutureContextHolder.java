package org.geeksword.springboot.util.nio;

import org.geeksword.springboot.util.model.future.Future;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FutureContextHolder {

    private static final Map<Integer, Future<?>> CONTEXT = new ConcurrentHashMap<>(1 << 5);

    public static Future<?> getFuture(final Integer futureId) {
        return CONTEXT.get(futureId);
    }

    public static Future<?> putFuture(final Integer futureId, final Future<?> future) {
        return CONTEXT.putIfAbsent(futureId, future);
    }

    public static void clear() {
        if (CONTEXT.isEmpty()) {
            return;
        }
        for (Map.Entry<Integer, Future<?>> entry : CONTEXT.entrySet()) {
            Future<?> value = entry.getValue();
            while (!value.done()) {
            }
        }
        CONTEXT.clear();
    }
}
