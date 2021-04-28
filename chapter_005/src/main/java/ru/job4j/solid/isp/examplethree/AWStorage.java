package ru.job4j.solid.isp.examplethree;

public class AWStorage implements Storage {
    @Override
    public void saveData() {
        System.out.println("save");
    }

    @Override
    public void loadDataToAzure() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void loadDataToAWS() {
        System.out.println("load to AWS. Oracle the best");
    }

}
