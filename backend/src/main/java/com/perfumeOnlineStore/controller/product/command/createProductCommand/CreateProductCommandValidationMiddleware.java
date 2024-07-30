package com.perfumeOnlineStore.controller.product.command.createProductCommand;

import an.awesome.pipelinr.Command;
import com.perfumeOnlineStore.customValidators.commandValidator.CommandValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Order(1)
@Component
public class CreateProductCommandValidationMiddleware implements Command.Middleware {
    private final ObjectProvider<CreateProductCommandValidator> validators;

    @Override
    public <CreateProductCommandResponse, CreateProductCommand extends Command<CreateProductCommandResponse>> CreateProductCommandResponse invoke(
            CreateProductCommand command,
            Next<CreateProductCommandResponse> next
    ) {
        validators.stream()
                .filter(v -> v.matches((com.perfumeOnlineStore.controller.product.command.createProductCommand.CreateProductCommand) command))
                .findFirst()
                .ifPresent(v -> v.validate((com.perfumeOnlineStore.controller.product.command.createProductCommand.CreateProductCommand) command));

        return next.invoke();
    }
}
