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
        System.out.println("Today is the end of the world");
    }

    public static void main(String[] args){
        Component component = new ConcreteComponent();
        Decorator decorator = new ConcreteDecorator(component);
        decorator.operation();
    }
}
