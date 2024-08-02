package com.perfumeOnlineStore.controller.discount.command.createDiscountCommand;

import an.awesome.pipelinr.Command;
import com.perfumeOnlineStore.entity.Discount;
import com.perfumeOnlineStore.mapper.discount.CreateDiscountCommandToDiscountMapper;
import com.perfumeOnlineStore.service.DiscountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateDiscountCommandHandler implements Command.Handler<CreateDiscountCommand, CreateDiscountCommandResponse> {
    private final DiscountService discountService;
    private final CreateDiscountCommandValidator validator;

    public CreateDiscountCommandResponse handle(CreateDiscountCommand command) {
        CreateDiscountCommandResponse resp = new CreateDiscountCommandResponse();

        validator.validate(command);

        try {
            Discount discount = CreateDiscountCommandToDiscountMapper.INSTANCE.toDiscount(command);

            discountService.saveDiscount(discount);

            resp.setSuccess(true);
            resp.setStatusCode(HttpStatus.CREATED.value());
            resp.setStatus(HttpStatus.CREATED.name());
            resp.setPayload(discount);

            return resp;
        } catch (Exception e) {
            return resp;
        }
    }
}
