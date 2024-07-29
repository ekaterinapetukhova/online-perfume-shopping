package com.perfumeOnlineStore.controller.response.error;

import com.perfumeOnlineStore.controller.response.ResponseBase;
import lombok.AllArgsConstructor;
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
