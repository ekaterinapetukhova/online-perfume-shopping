package com.perfumeOnlineStore.controller.discount.command.updateDiscountCommand;

import an.awesome.pipelinr.Command;
import com.perfumeOnlineStore.entity.Discount;
import com.perfumeOnlineStore.mapper.discount.UpdateDiscountCommandToDiscountMapper;
import com.perfumeOnlineStore.service.DiscountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class UpdateDiscountCommandHandler implements Command.Handler<UpdateDiscountCommand, UpdateDiscountCommandResponse> {
    private final DiscountService discountService;
    private final UpdateDiscountCommandValidator validator;

    public UpdateDiscountCommandResponse handle(UpdateDiscountCommand command) {
        UpdateDiscountCommandResponse resp = new UpdateDiscountCommandResponse();

        validator.validate(command);

        try {
            Optional<Discount> existingDiscount = discountService.findDiscountById(command.getId());

            if (existingDiscount.isPresent()) {
                Discount discount = UpdateDiscountCommandToDiscountMapper.INSTANCE.toDiscount(command);

                discountService.saveDiscount(discount);

                resp.setSuccess(true);
                resp.setStatus(HttpStatus.OK.name());
                resp.setStatusCode(HttpStatus.OK.value());
                resp.setPayload(discount);
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
