package com.perfumeOnlineStore.dto;

import com.perfumeOnlineStore.entity.Order;
import lombok.Data;

import java.util.List;

@Data
public class UserWithProductsDto extends UserDto {
    private List<Order> orders;
}
