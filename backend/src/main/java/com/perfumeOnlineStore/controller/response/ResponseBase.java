package com.perfumeOnlineStore.controller.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
public class ResponseBase<T> {
    private boolean success = false;
    private String status = HttpStatus.INTERNAL_SERVER_ERROR.name();
    private int statusCode = HttpStatus.INTERNAL_SERVER_ERROR.value();
    private T payload;

    public ResponseBase(T payload) {
        this.payload = payload;
    }
}
