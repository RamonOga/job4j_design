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

    String origin;

    String line;

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(LastTask.class.getSimpleName())
                .forks(1)
                .build();

        new Runner(opt).run();
    }
    @Benchmark
    public void startSetTest(Blackhole bh) {
        bh.consume(generateBySet(origin, line));
    }
    @Benchmark
    public void startLoopTest(Blackhole bh) {
        bh.consume(generateByLoop(origin, line));
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
    @Setup
    public void init() {
        origin = "\"Мой дядя самых честных правил, \" +\n" +
                "                                \"Когда не в шутку занемог, \" +\n" +
                "                                \"Он уважать себя заставил \" +\n" +
                "                                \"И лучше выдумать не мог. \" +\n" +
                "                                \"Его пример другим наука; \" +\n" +
                "                                \"Но, боже мой, какая скука \" +\n" +
                "                                \"С больным сидеть и день и ночь, \" +\n" +
                "                                \"Не отходя ни шагу прочь! \" +\n" +
                "                                \"Какое низкое коварство \" +\n" +
                "                                \"Полуживого забавлять, \" +\n" +
                "                                \"Ему подушки поправлять, \" +\n" +
                "                                \"Печально подносить лекарство, \" +\n" +
                "                                \"Вздыхать и думать про себя: \" +\n" +
                "                                \"Когда же черт возьмет тебя!\"";
        line = "Мой дядя мог думать про тебя и день и ночь";
    }
}


