package com.perfumeOnlineStore.controller.response.errorResponse.notFoundError;

import com.perfumeOnlineStore.controller.response.errorResponse.ErrorPayload;
import com.perfumeOnlineStore.controller.response.errorResponse.ErrorResponseBase;
import org.springframework.http.HttpStatus;

public class NotFoundErrorResponse extends ErrorResponseBase {
    public NotFoundErrorResponse() {
        super(
                new ErrorPayload(
                    HttpStatus.NOT_FOUND.value(),
                    HttpStatus.NOT_FOUND.name())
        );
    }
}
