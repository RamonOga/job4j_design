package ru.job4j.jmh;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)
@Fork(value = 2, jvmArgs = {"-Xms2G", "-Xmx2G"})
@Warmup(iterations = 3)
@Measurement(iterations = 8)
public class SimpleExample {

    List<String> list;
    String rsl;

    @Setup
    public void init() {
        list = new ArrayList<>();
        list.add("test");
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(SimpleExample.class.getSimpleName())
                .forks(1)
                .build();

        new Runner(opt).run();

    }

    @Benchmark
    public String test(Blackhole bh) {
        for (long i = 0; i < 1000000000; i++) {
            rsl = list.get(0);
        }
        bh.consume(list);
        return rsl;
    }
}
