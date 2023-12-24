package dians.hw.winespotter.pipeAndFilter;

public interface Filter<T> {
    T execute(T input);
}

