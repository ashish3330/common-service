package com.neighbourly.commonservice.errorhandling;

import java.util.function.Function;
import java.util.function.Supplier;

public class Try<T> {
    private final T value;
    private final Throwable error;

    private Try(T value, Throwable error) {
        this.value = value;
        this.error = error;
    }

    public static <T> Try<T> of(Supplier<T> supplier) {
        try {
            return new Try<>(supplier.get(), null);
        } catch (Throwable e) {
            return new Try<>(null, e);
        }
    }

    public boolean isSuccess() { return error == null; }
    public boolean isFailure() { return error != null; }

    public T get() throws Throwable {
        if (isFailure()) throw error;
        return value;
    }

    public T getOrElse(T defaultValue) {
        return isSuccess() ? value : defaultValue;
    }

    public <U> Try<U> map(Function<T, U> mapper) {
        if (isFailure()) return new Try<>(null, error);
        return Try.of(() -> mapper.apply(value));
    }
}