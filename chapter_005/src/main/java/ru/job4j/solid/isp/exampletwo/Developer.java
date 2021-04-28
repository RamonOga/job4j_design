package ru.job4j.solid.isp.exampletwo;

public class Developer implements Employee {
    @Override
    public void writeCode() {
        System.out.println("Write mega code");
    }

    @Override
    public void testingPO() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void repairCopm() {
        throw new UnsupportedOperationException();
    }
}
