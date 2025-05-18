package com.neighbourly.commonservice.dispatcher;

import com.neighbourly.commonservice.errorhandling.Either;

public interface Handler<T, R> {
    Either<String, R> handle(T dispatchable);
}