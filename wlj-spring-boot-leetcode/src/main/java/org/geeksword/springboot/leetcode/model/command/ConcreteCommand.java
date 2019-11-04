package org.geeksword.springboot.leetcode.model.command;

/**
 * 具体命令类
 */
public class ConcreteCommand implements Command {

    private final Receiver receiver;

    public ConcreteCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.action();
    }
}
