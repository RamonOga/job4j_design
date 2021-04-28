package ru.job4j.solid.isp.exampleone;

public class Rifle implements Weapon{

    @Override
    public void autoShot() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void shot() {
        System.out.println("piu");
    }

    @Override
    public void reload() {
        System.out.println("reload");
    }

    @Override
    public void prick() {
        throw new UnsupportedOperationException();
    }
}
