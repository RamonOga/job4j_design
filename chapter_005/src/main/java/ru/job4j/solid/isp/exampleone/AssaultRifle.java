package ru.job4j.solid.isp.exampleone;

public class AssaultRifle implements Weapon {
    @Override
    public void autoShot() {
        System.out.println("tra-ta-ta");
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
