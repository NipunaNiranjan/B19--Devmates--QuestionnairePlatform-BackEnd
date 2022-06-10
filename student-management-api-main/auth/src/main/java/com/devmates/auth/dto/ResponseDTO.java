package com.devmates.auth.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseDTO<T> {
    private int statusCode;
    private String status;

    @Builder.Default
    private String message = "Success!";

    private T body;
}

