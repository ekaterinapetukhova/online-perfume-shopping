package com.perfumeOnlineStore.controller.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseBase<T> {
    private String status = "success";
    private T payload;

    public ResponseBase(T payload) {
        this.payload = payload;
    }
}
