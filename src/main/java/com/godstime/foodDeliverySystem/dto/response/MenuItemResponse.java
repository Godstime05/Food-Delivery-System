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

//    public MenuItemResponse() {
//    }

    private String description;


//    public MenuItemResponse(Boolean success, String message) {
//        this.success = success;
//        this.message = message;
//        this.data = data;
//    }

}
