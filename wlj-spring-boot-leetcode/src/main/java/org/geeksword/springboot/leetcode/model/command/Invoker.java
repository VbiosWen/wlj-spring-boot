package org.geeksword.springboot.leetcode.model.command;

/**
 * 调用者
 */
public class Invoker {

    private final Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    public void call() {
        command.execute();
    }

}
