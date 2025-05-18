package com.neighbourly.commonservice.dispatcher;

import java.time.Instant;
import java.util.UUID;

public abstract class Event {
    private final UUID eventId = UUID.randomUUID();
    private final Instant occurredAt = Instant.now();

    public UUID getEventId() { return eventId; }
    public Instant getOccurredAt() { return occurredAt; }
}