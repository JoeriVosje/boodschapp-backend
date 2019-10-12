package com.hhs.boodschapp.model.entity.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CustomerResponse {
    private String statusMessage;
    private int customerId;
}
