package com.perfumeOnlineStore.controller.product.command.deleteProductCommand;

import an.awesome.pipelinr.Command;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
@RequiredArgsConstructor
public class DeleteProductCommandValidationMiddleware implements Command.Middleware{
    private final ObjectProvider<DeleteProductCommandValidator> validators;

    @Override
    public <deleteProductCommandResponse, deleteProductCommand extends Command<deleteProductCommandResponse>> deleteProductCommandResponse invoke(
            deleteProductCommand command,
            Next<deleteProductCommandResponse> next
    ) {
        validators.stream()
                .filter(v -> v.matches((DeleteProductCommand) command))
                .findFirst()
                .ifPresent(v -> v.validate((DeleteProductCommand) command));

        return next.invoke();
    }

}
