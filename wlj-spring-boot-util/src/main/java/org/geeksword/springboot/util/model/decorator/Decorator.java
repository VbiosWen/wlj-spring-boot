package org.geeksword.springboot.util.model.decorator;

/**
 * 抽象装饰类
 */
public abstract class Decorator implements Component {

    private final Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void operation() {
        // TODO do same things;
    }
}
