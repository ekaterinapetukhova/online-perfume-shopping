package com.perfumeOnlineStore.controller.response.errorResponse.serverError;

import com.perfumeOnlineStore.controller.response.errorResponse.ErrorPayload;
import com.perfumeOnlineStore.controller.response.errorResponse.ErrorResponseBase;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ServerErrorResponse extends ErrorResponseBase {
    public ServerErrorResponse() {
        super(
                new ErrorPayload(
                        HttpStatus.INTERNAL_SERVER_ERROR.value(),
                        HttpStatus.INTERNAL_SERVER_ERROR.name()
                )
        );
    }
}
