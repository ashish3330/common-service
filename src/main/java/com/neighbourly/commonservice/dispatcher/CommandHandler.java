package com.neighbourly.commonservice.dispatcher;

import com.neighbourly.commonservice.errorhandling.Either;

public interface CommandHandler<C extends Command<R>, R> extends Handler<C, R> {
}