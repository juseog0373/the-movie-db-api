package com.ecocow.themovieapi.common.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ResponseDto<T> {
    private boolean result;
    private int status;
    private String message;
    private T data;
}
