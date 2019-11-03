package org.geeksword.springboot.util.model.memento;

public class Originator {

    private String state;

    public Memento createNewMemento(){
        return new Memento(this);
    }

    public void restoreMemento(Memento memento){
        state = memento.getState();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
