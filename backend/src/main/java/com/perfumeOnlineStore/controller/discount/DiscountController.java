package com.perfumeOnlineStore.controller.discount;

import an.awesome.pipelinr.Pipeline;
import com.perfumeOnlineStore.controller.discount.command.createDiscountCommand.*;
import com.perfumeOnlineStore.controller.discount.command.deleteDiscountCommand.*;
import com.perfumeOnlineStore.controller.discount.command.updateDiscountCommand.*;
import com.perfumeOnlineStore.controller.discount.query.getAllDiscountsQuery.*;
import com.perfumeOnlineStore.controller.discount.query.getDiscountByIdQuery.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/discounts")
@RequiredArgsConstructor
public class DiscountController {
    private final Pipeline pipeline;
    private final GetAllDiscountsQueryHandler getAllDiscountsQueryHandler;
    private final GetDiscountByIdQueryHandler getDiscountByIdQueryHandler;

    @GetMapping
    public GetAllDiscountsQueryResponse getAllDiscounts() {
        return getAllDiscountsQueryHandler.handle();
    }

    @GetMapping("/{discountId}")
    public GetDiscountByIdResponse getDiscountById(@PathVariable("discountId") Long id) {
       return getDiscountByIdQueryHandler.handle(id);
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public CreateDiscountCommandResponse createDiscount(@RequestBody CreateDiscountCommand createCommand) {
        return createCommand.execute(pipeline);
    }

    @DeleteMapping("/{discountId}")
    public DeleteDiscountCommandResponse deleteDiscount(@PathVariable("discountId") Long id) {
        DeleteDiscountCommand deleteCommand = new DeleteDiscountCommand(id);

        return deleteCommand.execute(pipeline);
    }

    @PutMapping(
            value = "/{discountId}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public UpdateDiscountCommandResponse updateDiscountById(@PathVariable("discountId") Long id,
                                                            @RequestBody UpdateDiscountCommand updateCommand) {
        updateCommand.setId(id);

        return updateCommand.execute(pipeline);
    }
}
