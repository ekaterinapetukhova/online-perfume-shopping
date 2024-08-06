package com.perfumeOnlineStore.controller.discount.query.getAllDiscountsQuery;

import an.awesome.pipelinr.Command;
import com.perfumeOnlineStore.dto.DiscountDto;
import com.perfumeOnlineStore.entity.Discount;
import com.perfumeOnlineStore.mapper.discount.DiscountToDtoMapper;
import com.perfumeOnlineStore.service.DiscountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class GetAllDiscountsQueryHandler implements Command.Handler<GetAllDiscountsQuery, GetAllDiscountsQueryResponse> {
    private final DiscountService discountService;

    public GetAllDiscountsQueryResponse handle(GetAllDiscountsQuery query) {
        GetAllDiscountsQueryResponse resp = new GetAllDiscountsQueryResponse();

        try {
            List<Discount> discounts = discountService.findAllDiscounts();

            List<DiscountDto> discountsDto = discounts.stream()
                    .map(DiscountToDtoMapper.INSTANCE::toDto)
                    .toList();

            resp.setSuccess(true);
            resp.setStatusCode(HttpStatus.OK.value());
            resp.setStatus(HttpStatus.OK.name());
            resp.setPayload(discountsDto);

            return resp;
        } catch (Exception e) {
            return resp;
        }
    }
}
