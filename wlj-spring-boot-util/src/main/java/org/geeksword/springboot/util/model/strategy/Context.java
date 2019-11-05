package org.geeksword.springboot.util.model.strategy;

/**
 * @wenliujie 环境类
 */
public class Context {


    private final Strategy strategy;


    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void algorithm() {
        strategy.algorithm();
    }
}
