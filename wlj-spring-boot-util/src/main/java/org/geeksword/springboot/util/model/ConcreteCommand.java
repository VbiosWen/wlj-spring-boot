package org.geeksword.springboot.util.model;

public class ConcreteCommand implements Command {

    private final Receiver receiver;

    public ConcreteCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        this.receiver.action();
    }
}
