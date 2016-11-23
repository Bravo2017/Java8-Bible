package me.hgwood.bulky;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

/**
 * @see Bulky#upTo(Class[])
 */
public class UpToFailureCollector<T> implements Collector<Supplier<T>, Collection<T>, Stream<T>> {

    private final Collection<Class<? extends RuntimeException>> failures;
    private final Set<Characteristics> characteristics = new HashSet<>();
    private boolean collecting = true;

    public UpToFailureCollector(Class<? extends RuntimeException>... failures) {
        this.failures = asList(failures);
    }

    @Override public Supplier<Collection<T>> supplier() {
        return ArrayList::new;
    }

    @Override public BiConsumer<Collection<T>, Supplier<T>> accumulator() {
        return (accumulator, element) -> {
            if (!collecting) return;
            try {
                accumulator.add(element.get());
            } catch (RuntimeException e) {
                if (failures.contains(e.getClass()))
                    collecting = false;;
            }
        };
    }

    @Override public BinaryOperator<Collection<T>> combiner() {
        return (left, right) -> { left.addAll(right); return left; };
    }

    @Override public Function<Collection<T>, Stream<T>> finisher() {
        return result -> result.stream();
    }

    @Override public Set<Characteristics> characteristics() {
        return characteristics;
    }

}
