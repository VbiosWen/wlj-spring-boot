package org.geeksword.springboot.util.model.observer;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class ObserverThread<T> extends Thread implements ThreadObserver {


    private final TaskLifecycle<T> taskLifecycle;

    private final Task<T> task;

    private Cycle cycle;

    public ObserverThread(Task<T> task) {
        this(new TaskLifecycle.EmptyLifecycle<>(), task);
    }

    public ObserverThread(TaskLifecycle<T> taskLifecycle, Task<T> task) {
        super();

        if (Objects.isNull(task)) {
            throw new IllegalArgumentException("The task is required.");
        }

        this.taskLifecycle = taskLifecycle;
        this.task = task;
    }

    @Override
    public final void run() {
        this.update(Cycle.STARTED, null, null);
        try {
            this.update(Cycle.RUNNING, null, null);
            T result = this.task.call();
            this.update(Cycle.DONE, result, null);
        } catch (Exception e) {
            this.update(Cycle.ERROR, null, e);
        }
    }

    private void update(Cycle cycle, T result, Exception e) {
        this.cycle = cycle;
        if (Objects.isNull(taskLifecycle)) {
            return;
        }

        try {
            switch (cycle) {
                case STARTED:
                    this.taskLifecycle.onStart(currentThread());
                    break;
                case RUNNING:
                    this.taskLifecycle.onRunning(currentThread());
                    break;
                case DONE:
                    this.taskLifecycle.onFinish(currentThread(), result);
                    break;
                case ERROR:
                    this.taskLifecycle.onError(currentThread(), e);
                    break;
            }
        } catch (Exception ex) {
            if (Objects.equals(Cycle.ERROR, cycle)) {
                throw ex;
            }
        }
    }

    @Override
    public Cycle getCycle() {
        return this.cycle;
    }

    @Override
    public void start() {
        super.start();
    }

    @Override
    public void interrupt() {
        super.interrupt();
    }

    public static void main(String[] args) {
        final TaskLifecycle<String> taskLifecycle = new TaskLifecycle.EmptyLifecycle<String>() {
            @Override
            public void onFinish(Thread thread, String result) {
                System.out.println("The result is :" + result);
            }
        };

        ThreadObserver threadObserver = new ObserverThread<>(taskLifecycle, () -> {
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("finish done");
            return "Hello Observer";
        });
        threadObserver.start();

    }
}
