package com.perfumeOnlineStore.controller.response.error;

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
