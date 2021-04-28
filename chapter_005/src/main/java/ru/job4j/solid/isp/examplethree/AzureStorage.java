package ru.job4j.solid.isp.examplethree;

public class AzureStorage implements Storage {

    @Override
    public void saveData() {
        System.out.println("save");
    }

    @Override
    public void loadDataToAzure() {
        System.out.println("load to azure! MS the best");
    }

    @Override
    public void loadDataToAWS() {
        throw new UnsupportedOperationException();
    }
}
