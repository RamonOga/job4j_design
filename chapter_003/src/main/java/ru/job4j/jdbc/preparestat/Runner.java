package ru.job4j.jdbc.preparestat;

public class Runner {
    public static void main(String[] args) throws Exception {
        City c1 = new City(100, "Elabuga", 80000);
        City c2 = new City(101, "Almet", 140000);
        City c3 = new City(102, "Kzn", 1500000);
        PrepareStatementDemo psd = new PrepareStatementDemo();

        psd.findAll().forEach(System.out::println);
    }
}
