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

import java.util.UUID;

@RestController
@RequestMapping("api/v1/discounts")
@RequiredArgsConstructor
public class DiscountController {
    private final Pipeline pipeline;

    @GetMapping
    public GetAllDiscountsQueryResponse getAllDiscounts() {
        GetAllDiscountsQuery query = new GetAllDiscountsQuery();

        return query.execute(pipeline);
    }

    @GetMapping("/{discountId}")
    public GetDiscountByIdResponse getDiscountById(@PathVariable("discountId") UUID id) {
        GetDiscountByIdQuery query = new GetDiscountByIdQuery(id);

       return query.execute(pipeline);
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public CreateDiscountCommandResponse createDiscount(@RequestBody CreateDiscountCommand createCommand) {
        return createCommand.execute(pipeline);
    }

    @DeleteMapping("/{discountId}")
    public DeleteDiscountCommandResponse deleteDiscount(@PathVariable("discountId") UUID id) {
        DeleteDiscountCommand deleteCommand = new DeleteDiscountCommand(id);

        return deleteCommand.execute(pipeline);
    }

    @PutMapping(
            value = "/{discountId}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public UpdateDiscountCommandResponse updateDiscountById(@PathVariable("discountId") UUID id,
                                                            @RequestBody UpdateDiscountCommand updateCommand) {
        updateCommand.setId(id);

        return updateCommand.execute(pipeline);
    }
}
