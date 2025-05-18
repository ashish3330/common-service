package com.neighbourly.commonservice.dispatcher.registry;

import com.neighbourly.commonservice.dispatcher.Handler;
import java.util.Optional;

public interface HandlerRegistry {
    <T, R> void registerHandler(Class<T> type, Handler<T, R> handler);
    <T, R> Optional<Handler<T, R>> getHandler(T dispatchable);
}