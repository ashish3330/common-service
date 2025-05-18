package com.neighbourly.commonservice.dispatcher;

import com.neighbourly.commonservice.errorhandling.Either;

public interface EventHandler<E extends Event> extends Handler<E, Void> {
}