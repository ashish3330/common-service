package com.neighbourly.commonservice.dispatcher;

import com.neighbourly.commonservice.dispatcher.registry.HandlerRegistry;
import com.neighbourly.commonservice.errorhandling.Either;
import java.util.Optional;

public class SyncDispatcher implements Dispatcher {
    private final HandlerRegistry registry;

    public SyncDispatcher(HandlerRegistry registry) {
        this.registry = registry;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> Either<String, T> dispatch(Object dispatchable) {
        Optional<? extends Handler<?, ?>> handlerOptional = registry.getHandler(dispatchable);

        return handlerOptional
                .map(handler -> {
                    // Safe cast after checking handler type
                    Handler<Object, Object> typedHandler = (Handler<Object, Object>) handler;
                    Either<String, Object> result = typedHandler.handle(dispatchable);
                    return (Either<String, T>) result;
                })
                .orElseGet(() -> Either.left("No handler registered for: " + dispatchable.getClass()));
    }
}