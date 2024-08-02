package com.perfumeOnlineStore.controller.discount.query.getDiscountByIdQuery;

import com.perfumeOnlineStore.dto.DiscountDto;
import com.perfumeOnlineStore.entity.Discount;
import com.perfumeOnlineStore.mapper.discount.DiscountToDtoMapper;
import com.perfumeOnlineStore.service.DiscountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class GetDiscountByIdQueryHandler {
    private final DiscountService discountService;

    public GetDiscountByIdResponse handle(Long id) {
        GetDiscountByIdResponse resp = new GetDiscountByIdResponse();

        try {
            Optional<Discount> discount = discountService.findDiscountById(id);

            if (discount.isPresent()) {
                DiscountDto discountDto = discount.map(DiscountToDtoMapper.INSTANCE::toDto).get();

                resp.setSuccess(true);
                resp.setStatusCode(HttpStatus.OK.value());
                resp.setStatus(HttpStatus.OK.name());
                resp.setPayload(discountDto);
            } else {
                resp.setStatusCode(HttpStatus.NOT_FOUND.value());
                resp.setStatus(HttpStatus.NOT_FOUND.name());
                resp.setPayload(null);
            }

            return resp;
        } catch (Exception e) {
            return resp;
        }
    }
}
