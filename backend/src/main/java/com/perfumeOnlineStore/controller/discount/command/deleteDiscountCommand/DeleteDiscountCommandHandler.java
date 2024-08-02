package com.perfumeOnlineStore.controller.discount.command.deleteDiscountCommand;

import an.awesome.pipelinr.Command;
import com.perfumeOnlineStore.entity.Discount;
import com.perfumeOnlineStore.service.DiscountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DeleteDiscountCommandHandler implements Command.Handler<DeleteDiscountCommand, DeleteDiscountCommandResponse> {
    private final DiscountService discountService;
    private final DeleteDiscountCommandValidator validator;

    @Override
    public DeleteDiscountCommandResponse handle(DeleteDiscountCommand command) {
        DeleteDiscountCommandResponse resp = new DeleteDiscountCommandResponse();

        validator.validate(command);

        try {
            Optional<Discount> existingDiscount = discountService.findDiscountById(command.getId());

            if (existingDiscount.isPresent()) {
                discountService.deleteDiscount(existingDiscount.get());

                resp.setSuccess(true);
                resp.setStatus(HttpStatus.NO_CONTENT.name());
                resp.setStatusCode(HttpStatus.NO_CONTENT.value());
                resp.setPayload(existingDiscount.get().getId());
            } else {
                resp.setStatus(HttpStatus.NOT_FOUND.name());
                resp.setStatusCode(HttpStatus.NOT_FOUND.value());
                resp.setPayload(null);
            }

            return resp;
        } catch (Exception e) {
            return resp;
        }
    }
}
