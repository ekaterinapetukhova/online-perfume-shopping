package com.perfumeOnlineStore.dto;

import com.perfumeOnlineStore.entity.Order;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserWithProductsDto extends UserDto {
    private List<Order> orders;
}
