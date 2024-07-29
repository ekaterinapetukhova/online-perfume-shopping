package com.perfumeOnlineStore.controller.response.error.notFound;

import com.perfumeOnlineStore.controller.response.error.ErrorPayload;
import com.perfumeOnlineStore.controller.response.error.ErrorResponseBase;
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
