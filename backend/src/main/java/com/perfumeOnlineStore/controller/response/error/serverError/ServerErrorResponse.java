package com.perfumeOnlineStore.controller.response.error.serverError;

import com.perfumeOnlineStore.controller.response.error.ErrorPayload;
import com.perfumeOnlineStore.controller.response.error.ErrorResponseBase;
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
