package com.hhs.boodschapp.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class BoodschappErrorResponse {
    private String statusMessage;
}
