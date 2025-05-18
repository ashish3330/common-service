package com.neighbourly.commonservice.dispatcher;

import java.time.Instant;
import java.util.UUID;

public abstract class Command<R> {
    private final UUID commandId = UUID.randomUUID();
    private final Instant createdAt = Instant.now();

    public UUID getCommandId() { return commandId; }
    public Instant getCreatedAt() { return createdAt; }
}