package com.godstime.foodDeliverySystem.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantResponse {
    private Long id;
    private String name;
    private String email;
    private String phoneNo;
    private String address;
    private String cuisine;

}
