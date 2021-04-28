package ru.job4j.solid.isp.exampletwo;

public class SysAdmin implements Employee {

    @Override
    public void writeCode() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void testingPO() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void repairCopm() {
        System.out.println("Repair computers");
    }
}
