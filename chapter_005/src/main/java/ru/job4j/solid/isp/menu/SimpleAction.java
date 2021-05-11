package ru.job4j.solid.isp.menu;

public class SimpleAction implements Action {
    @Override
    public void act() {
        System.out.println("Activation : " + this.toString());
    }
}
