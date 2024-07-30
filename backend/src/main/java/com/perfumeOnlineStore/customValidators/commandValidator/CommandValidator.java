package com.perfumeOnlineStore.customValidators.commandValidator;

import an.awesome.pipelinr.Command;
import com.google.common.reflect.TypeToken;

public interface CommandValidator<C extends Command<R>, R> {
    void validate(C command);

    default boolean matches(C command) {
        TypeToken<C> typeToken = new TypeToken<C>(getClass()) {};

        return typeToken.isSubtypeOf(command.getClass());

    }
}
