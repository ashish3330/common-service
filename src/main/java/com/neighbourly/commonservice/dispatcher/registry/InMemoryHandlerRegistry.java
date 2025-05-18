package com.neighbourly.commonservice.dispatcher.registry;

import com.neighbourly.commonservice.dispatcher.Handler;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryHandlerRegistry implements HandlerRegistry {
    private final Map<Class<?>, Handler<?, ?>> handlers = new ConcurrentHashMap<>();

    @Override
    public <T, R> void registerHandler(Class<T> type, Handler<T, R> handler) {
        handlers.put(type, handler);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T, R> Optional<Handler<T, R>> getHandler(T dispatchable) {
        return Optional.ofNullable((Handler<T, R>) handlers.get(dispatchable.getClass()));
    }
}