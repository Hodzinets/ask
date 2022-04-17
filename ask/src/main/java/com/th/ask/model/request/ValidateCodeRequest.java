package com.th.ask.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public
class ValidateCodeRequest {
    private Integer code;
    private String username;
}