
package ru.job4j.jmh;

import static org.junit.Assert.*;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

public class LastTaskTest1 {
    @Test
    public void whenLineGnrTrue() {
        assertThat(
                LastTask.generateByLoop(
                        "Мама мыла раму и окно",
                        "мыла окно"
                ),
                is(true)
        );
    }

    @Test
    public void whenLineGnrFalse() {
        assertThat(
                LastTask.generateByLoop(
                        "Мама мыла раму и окно",
                        "мыла пол"
                ),
                is(false)
        );
    }

    @Test
    public void whenLongTextTrue() {
        assertThat(
                LastTask.generateByLoop(
                        "Мой дядя самых честных правил, " +
                                "Когда не в шутку занемог, " +
                                "Он уважать себя заставил " +
                                "И лучше выдумать не мог. " +
                                "Его пример другим наука; " +
                                "Но, боже мой, какая скука " +
                                "С больным сидеть и день и ночь, " +
                                "Не отходя ни шагу прочь! " +
                                "Какое низкое коварство " +
                                "Полуживого забавлять, " +
                                "Ему подушки поправлять, " +
                                "Печально подносить лекарство, " +
                                "Вздыхать и думать про себя: " +
                                "Когда же черт возьмет тебя!",
                        "Мой дядя мог думать про тебя и день и ночь"
                ),
                is(true)
        );
    }
    @Test
    public void whenLongTextFalse() {
        assertThat(
                LastTask.generateByLoop(
                        "Мой дядя самых честных правил, " +
                                "Когда не в шутку занемог, " +
                                "Он уважать себя заставил " +
                                "И лучше выдумать не мог. " +
                                "Его пример другим наука; " +
                                "Но, боже мой, какая скука " +
                                "С больным сидеть и день и ночь, " +
                                "Не отходя ни шагу прочь! " +
                                "Какое низкое коварство " +
                                "Полуживого забавлять, " +
                                "Ему подушки поправлять, " +
                                "Печально подносить лекарство, " +
                                "Вздыхать и думать про себя: " +
                                "Когда же черт возьмет тебя!",
                        "Мой дядя мог думать про Linux и Java день и ночь"
                ),
                is(false)
        );
    }

}
