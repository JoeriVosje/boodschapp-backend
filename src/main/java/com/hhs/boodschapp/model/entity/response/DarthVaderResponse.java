package com.hhs.boodschapp.model.entity.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class DarthVaderResponse {
    private String statusMessage;
    private int customersDeleted;
    private int shoppingListsDeleted;
    private int productsDeleted;
}
