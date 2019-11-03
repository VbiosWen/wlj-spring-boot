package org.geeksword.springboot.util.model;

public class ConcreteInvoker implements Invoker {


    private final Command command;

    public ConcreteInvoker(Command command) {
        this.command = command;
    }

    @Override
    public void call() {
        this.command.execute();
    }
}
