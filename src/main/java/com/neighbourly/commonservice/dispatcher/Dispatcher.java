package com.neighbourly.commonservice.dispatcher;

import com.neighbourly.commonservice.errorhandling.Either;

public interface Dispatcher {
    <T> Either<String, T> dispatch(Object dispatchable);
}