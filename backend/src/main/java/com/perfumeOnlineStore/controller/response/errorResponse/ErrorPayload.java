package com.perfumeOnlineStore.controller.response.errorResponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ErrorPayload {
    private int code;
    private String message;
}
