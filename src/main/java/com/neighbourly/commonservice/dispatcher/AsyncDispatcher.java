package com.neighbourly.commonservice.dispatcher;

import com.neighbourly.commonservice.dispatcher.registry.HandlerRegistry;
import com.neighbourly.commonservice.errorhandling.Either;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

public class AsyncDispatcher implements Dispatcher {
    private final HandlerRegistry registry;
    private final Executor executor;

    public AsyncDispatcher(HandlerRegistry registry, Executor executor) {
        this.registry = registry;
        this.executor = executor;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> Either<String, T> dispatch(Object dispatchable) {
        CompletableFuture<Either<String, T>> future = new CompletableFuture<>();

        executor.execute(() -> {
            Optional<? extends Handler<?, ?>> handlerOptional = registry.getHandler(dispatchable);

            if (handlerOptional.isPresent()) {
                try {
                    Handler<Object, Object> handler = (Handler<Object, Object>) handlerOptional.get();
                    Either<String, Object> result = handler.handle(dispatchable);
                    future.complete((Either<String, T>) result);
                } catch (ClassCastException e) {
                    future.complete(Either.left("Type mismatch in handler for: " + dispatchable.getClass()));
                }
            } else {
                future.complete(Either.left("No handler registered for: " + dispatchable.getClass()));
            }
        });

        return Either.right(null); // Immediate return placeholder
    }
}