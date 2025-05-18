package com.neighbourly.commonservice.errorhandling;

import java.util.function.Function;

public class Either<L, R> {
    private final L left;
    private final R right;

    private Either(L left, R right) {
        this.left = left;
        this.right = right;
    }

    public static <L, R> Either<L, R> left(L value) {
        return new Either<>(value, null);
    }

    public static <L, R> Either<L, R> right(R value) {
        return new Either<>(null, value);
    }

    public boolean isLeft() { return left != null; }
    public boolean isRight() { return right != null; }
    public L getLeft() { return left; }
    public R getRight() { return right; }

    public <T> T fold(Function<L, T> leftFunc, Function<R, T> rightFunc) {
        return isLeft() ? leftFunc.apply(left) : rightFunc.apply(right);
    }

    // Add map method
    public <T> Either<L, T> map(Function<R, T> mapper) {
        if (isLeft()) {
            return Either.left(left);
        }
        return Either.right(mapper.apply(right));
    }

    // Add flatMap method
    public <T> Either<L, T> flatMap(Function<R, Either<L, T>> mapper) {
        if (isLeft()) {
            return Either.left(left);
        }
        return mapper.apply(right);
    }
}