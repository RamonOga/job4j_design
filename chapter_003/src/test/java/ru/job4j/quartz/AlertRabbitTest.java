package ru.job4j.quartz;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class AlertRabbitTest {
    @Test
    public void rabbitPropTest() {
        Assert.assertEquals(10, AlertRabbit.readRabbitProperties());
    }
}