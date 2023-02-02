package com.godstime.foodDeliverySystem.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerResponse {

    private long id;
    private String name;
    private String email;
}
