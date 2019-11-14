package org.geeksword.springboot.util.model.decorator;

/**
 * 具体构件
 */
public class ConcreteComponent implements Component {
    @Override
    public void operation() {
        System.out.println("Hello World!");
    }
}
