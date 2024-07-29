package com.perfumeOnlineStore.controller.response.errorResponse;

import com.perfumeOnlineStore.controller.response.ResponseBase;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponseBase extends ResponseBase<ErrorPayload> {
    private String status = "error";

    public ErrorResponseBase(ErrorPayload payload) {
        super(payload);
    }
}
