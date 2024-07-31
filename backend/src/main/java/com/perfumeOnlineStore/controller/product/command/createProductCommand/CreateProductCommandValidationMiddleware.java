package com.perfumeOnlineStore.controller.product.command.createProductCommand;

import an.awesome.pipelinr.Command;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
@RequiredArgsConstructor
public class CreateProductCommandValidationMiddleware implements Command.Middleware {
    private final ObjectProvider<CreateProductCommandValidator> validators;

    @Override
    public <createProductCommandResponse, createProductCommand extends Command<createProductCommandResponse>> createProductCommandResponse invoke(
            createProductCommand command,
            Next<createProductCommandResponse> next
    ) {
        validators.stream()
                .filter(v -> v.matches((com.perfumeOnlineStore.controller.product.command.createProductCommand.CreateProductCommand) command))
                .findFirst()
                .ifPresent(v -> v.validate((com.perfumeOnlineStore.controller.product.command.createProductCommand.CreateProductCommand) command));

        return next.invoke();
    }
}