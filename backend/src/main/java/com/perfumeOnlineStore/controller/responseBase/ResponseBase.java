package com.perfumeOnlineStore.controller.responseBase;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
public class ResponseBase<T> {
    private boolean success = false;
    private String status = HttpStatus.INTERNAL_SERVER_ERROR.name();
    private int statusCode = HttpStatus.INTERNAL_SERVER_ERROR.value();
    private T payload;
}
