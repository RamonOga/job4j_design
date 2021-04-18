package ru.job4j.solid.srp.exampleThree;


public class TempSensor implements ITempSensor{
    int temperature;
    long time;

    @Override
    public void tempMethod1(int temp) {
        temperature = temp;
    }

    @Override
    public void tempMethod2() {
        temperature = 0;
    }

    @Override
    public void dateMethod1(long time) {
        this.time = time;
    }

    @Override
    public void dateMethod2() {
        time = System.currentTimeMillis();
    }
}
