package com.godstime.foodDeliverySystem.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantRequest {
    private long id;
    private String name;
    private String email;
    private String password;
    private String phoneNo;
    private String address;
    private String cuisine;

}
