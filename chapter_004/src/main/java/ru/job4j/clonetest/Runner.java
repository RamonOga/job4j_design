package ru.job4j.clonetest;

public class Runner {
    public static void main(String[] args) throws CloneNotSupportedException {
       

    }
}

class JavaDeveloper extends Developer{}

class Developer {
    @Override
    public Developer clone() throws CloneNotSupportedException {
        return (Developer) super.clone();
    }
}


