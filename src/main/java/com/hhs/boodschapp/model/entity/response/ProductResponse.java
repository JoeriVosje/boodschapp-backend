package com.hhs.boodschapp.model.entity.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ProductResponse {
    private String statusMessage;
    private int productId;
}

