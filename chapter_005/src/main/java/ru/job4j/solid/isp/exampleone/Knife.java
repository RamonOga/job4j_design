package ru.job4j.solid.isp.exampleone;

public class Knife implements Weapon {
    @Override
    public void autoShot() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void shot() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void reload() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void prick() {
        throw new UnsupportedOperationException();
    }
}
