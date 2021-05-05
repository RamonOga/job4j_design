package ru.job4j.jmh;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;


@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)
@Fork(value = 2, jvmArgs = {"-Xms2G", "-Xmx2G"})
@Warmup(iterations = 3)
@Measurement(iterations = 8)
public class LastTask {
    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(LastTask.class.getSimpleName())
                .forks(1)
                .build();

        new Runner(opt).run();
    }
    @Benchmark
    public void startSetTest(Blackhole bh) {
        bh.consume(generateBySet("Мой дядя самых честных правил, " +
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
                "Мой дядя мог думать про тебя и день и ночь"));
    }
    @Benchmark
    public void startLoopTest(Blackhole bh) {
        bh.consume(generateByLoop("Мой дядя самых честных правил, " +
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
                "Мой дядя мог думать про тебя и день и ночь"));
    }


    public static boolean generateBySet(String origin, String line) {
        boolean rsl = true;
        String[] lineArr = line.split(" ");
        String newOrigin = origin.replaceAll("\\p{Punct}", "");
        Set<String> set = new HashSet<>(Arrays.asList(newOrigin.split(" ")));
        for(String s : lineArr) {
            if (!set.contains(s)) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }

    public static boolean generateByLoop(String origin, String line) {
        boolean rsl = true;
        String newOrigin = origin.replaceAll("\\p{Punct}", "");
        String[] lineArr = line.split(" ");
        for (String s : lineArr) {
            if (!newOrigin.contains(s)){
                rsl = false;
                break;
            }
        }
        return rsl;
    }
}


