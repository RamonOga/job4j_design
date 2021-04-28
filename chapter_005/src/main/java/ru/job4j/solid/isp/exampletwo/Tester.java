package ru.job4j.solid.isp.exampletwo;

public class Tester implements Employee {
    @Override
    public void writeCode() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void testingPO() {
        System.out.println("Testing programs");
    }

    @Override
    public void repairCopm() {
        throw new UnsupportedOperationException();
    }
}
