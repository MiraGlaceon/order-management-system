package mira.space.oms;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.Executors;

@BenchmarkMode(Mode.AverageTime)
@Warmup(iterations = 1)
@Measurement(iterations = 2)
@State(Scope.Benchmark)
public class VirtualThreadsBenchmark {

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(VirtualThreadsBenchmark.class.getSimpleName())
                .forks(1)
                .build();
        new Runner(opt).run();
    }

    @Benchmark
    public void testVirtualThreads(Blackhole blackhole) {
        for (int i = 0; i <= 100; i++) {
            int finalI = i;
            Thread.startVirtualThread(() -> blackhole.consume(finalI));
        }
    }

    @Benchmark
    public void testCasualThread(Blackhole blackhole) {
        for (int i = 0; i <= 100; i++) {
            int finalI = i;
            Thread thread = new Thread(() -> blackhole.consume(finalI));
            thread.start();
        }
    }

    @Benchmark
    public void testVirtualThreadsExecutor(Blackhole blackhole) {
        try (var executorService = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 0; i <= 100; i++) {
                int finalI = i;
                executorService.submit(() -> blackhole.consume(finalI));
            }
        }
    }

    @Benchmark
    public void testCasualThreadExecutor(Blackhole blackhole) {
        try (var executorService = Executors.newFixedThreadPool(10)) {
            for (int i = 0; i <= 100; i++) {
                int finalI = i;
                executorService.submit(() -> blackhole.consume(finalI));
            }
        }
    }

    @Benchmark
    public void testVirtualThreadsExecutorHighLoad(Blackhole blackhole) {
        try (var executorService = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 0; i <= 100; i++) {
                executorService.submit(() -> Blackhole.consumeCPU(100_000_000));
            }
        }
    }

    @Benchmark
    public void testCasualThreadExecutorHighLoad(Blackhole blackhole) {
        try (var executorService = Executors.newFixedThreadPool(10)) {
            for (int i = 0; i <= 100; i++) {
                executorService.submit(() -> Blackhole.consumeCPU(100_000_000));
            }
        }
    }
}
