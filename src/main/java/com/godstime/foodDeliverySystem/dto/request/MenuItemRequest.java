package com.godstime.foodDeliverySystem.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuItemRequest {
    private String name;
    private Double price;
    private String description;
    private String imageUrl;

}
