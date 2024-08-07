package com.perfumeOnlineStore.dto;

import com.perfumeOnlineStore.entity.Order;
import lombok.*;

import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserWithProductsDto extends UserDto {
    private Set<Order> orders;
}
