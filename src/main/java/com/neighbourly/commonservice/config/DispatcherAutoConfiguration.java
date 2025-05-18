package com.neighbourly.commonservice.config;

import com.neighbourly.commonservice.dispatcher.*;
import com.neighbourly.commonservice.dispatcher.registry.HandlerRegistry;
import com.neighbourly.commonservice.dispatcher.registry.InMemoryHandlerRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import java.util.concurrent.Executors;

@Configuration
public class DispatcherAutoConfiguration {
    @Bean
    public HandlerRegistry handlerRegistry() {
        return new InMemoryHandlerRegistry();
    }

    @Bean
    @Primary
    public Dispatcher syncDispatcher(HandlerRegistry registry) {
        return new SyncDispatcher(registry);
    }

    @Bean
    public Dispatcher asyncDispatcher(HandlerRegistry registry) {
        return new AsyncDispatcher(registry, Executors.newCachedThreadPool());
    }
}