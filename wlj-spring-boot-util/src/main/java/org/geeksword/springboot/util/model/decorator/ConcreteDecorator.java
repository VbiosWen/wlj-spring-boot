package org.geeksword.springboot.util.model.decorator;

/**
 * 具体装饰者
 */
public class ConcreteDecorator extends Decorator {

    public ConcreteDecorator(Component component) {
        super(component);
    }


    @Override
    public void operation() {
        super.operation();
        addedBehavior();
    }

    private void addedBehavior() {
        // TODO do some thing that you love.
    }
}
