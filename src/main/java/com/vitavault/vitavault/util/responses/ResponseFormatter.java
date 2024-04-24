package com.vitavault.vitavault.util.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;

@AllArgsConstructor
@Builder
public class ResponseFormatter {
    private Object body;
    private String message;
}
