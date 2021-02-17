package ru.job4j.io;

import java.io.*;
;

public class Runner implements Serializable {
    int age;
    String name;

    public Runner(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        /*Runner runner = new Runner(44, "Shit");
        FileOutputStream fos = new FileOutputStream("test.out");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(runner);
        oos.flush();
        oos.close();*/

        FileInputStream fis = new FileInputStream("test.out");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Runner runner2 = (Runner) ois.readObject();
        System.out.println(runner2.getAge());
        System.out.println(runner2.getName());

    }
}
