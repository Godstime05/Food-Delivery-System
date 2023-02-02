package com.godstime.foodDeliverySystem.dto.response;

import com.godstime.foodDeliverySystem.models.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {
    private Long id;
    private Long menuItemId;
    private Integer quantity;


    public OrderResponse(Order order) {
    }
}
