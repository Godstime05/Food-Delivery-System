package com.godstime.foodDeliverySystem.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuItemResponse {
    private Long id;
    private String name;
    private Double price;
    private String description;
    private String imageUrl;

}
