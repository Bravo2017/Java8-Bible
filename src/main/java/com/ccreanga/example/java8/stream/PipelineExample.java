package com.ccreanga.example.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Stream;

public class PipelineExample {

    public void showOrder(Stream<String> stream) {
        //Pipeline - moving between streams
        stream.filter(s -> {
            System.out.println("filter: " + s);
            return true;
        }).forEach(s -> System.out.println("forEach: " + s));

        //Order is important - some operations will not pass further the element
        System.out.println("--------------------------------------------");

        stream.map(s -> {
            System.out.println("map: " + s);
            return s.toUpperCase();
        })
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return s.startsWith("A");
                })
                .forEach(s -> System.out.println("forEach: " + s));

        System.out.println("--------------------------------------------");

        stream.filter(s -> {
            System.out.println("filter: " + s);
            return s.startsWith("a");
        })
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .forEach(s -> System.out.println("forEach: " + s));

    }

    public void stateFulStreams(Stream<String> stream) {
        //some operations are stateful
        stream
                .sorted((s1, s2) -> {
                    System.out.printf("sort: %s; %s\n", s1, s2);
                    return s1.compareTo(s2);
                })
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return s.startsWith("a");
                })
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .forEach(s -> System.out.println("forEach: " + s));

    }

    public void parallelStreams(Stream<String> stream) {
        System.out.println("--------------------------------------------");
        ForkJoinPool commonPool = ForkJoinPool.commonPool();
        System.out.println("thread pool:" + commonPool.getParallelism());

        Arrays.asList("a1", "a2", "b1", "c2", "c1")
                .parallelStream()
                .filter(s -> {
                    System.out.format("filter: %s [%s]\n", s, Thread.currentThread().getName());
                    return true;
                })
                .map(s -> {
                    System.out.format("map: %s [%s]\n", s, Thread.currentThread().getName());
                    return s.toUpperCase();
                })
                .forEach(s -> System.out.format("forEach: %s [%s]\n", s, Thread.currentThread().getName()));
    }

    public void parallelStreamsCustomPool(Stream<String> stream) {

        ForkJoinPool forkJoinPool = new ForkJoinPool(Runtime.getRuntime().availableProcessors() - 1);
        try {
            forkJoinPool.submit(() ->
                            stream.parallel().
                                    filter(s -> {
                                        System.out.format("filter: %s [%s]\n", s, Thread.currentThread().getName());
                                        return true;
                                    })
                                    .map(s -> {
                                        System.out.format("map: %s [%s]\n", s, Thread.currentThread().getName());
                                        return s.toUpperCase();
                                    })
                                    .forEach(s -> System.out.format("forEach: %s [%s]\n", s, Thread.currentThread().getName())
                                    )
            ).get();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void terminalOperations(Stream<String> stream) {

        //computation on the source data is only performed when the terminal operation is initiated
        //non terminal operations : filter
        stream.filter(v -> {
            System.out.println("filter: " + v);
            return v.equals("adina");
        });

        //terminal operations : sum, foreach
        System.out.println(stream.filter(v -> {
            System.out.println("filter: " + v);
            return v.equals("adina");
        }).mapToInt(String::length).sum());
    }

    public static void main(String[] args) {
        Stream<String> stream = Stream.of("d2", "a2", "b1", "b3", "c");

        PipelineExample pipelineExample = new PipelineExample();

        pipelineExample.showOrder(stream);
        pipelineExample.stateFulStreams(stream);
        pipelineExample.terminalOperations(stream);
        pipelineExample.parallelStreams(stream);
        pipelineExample.parallelStreamsCustomPool(stream);


    }

}
