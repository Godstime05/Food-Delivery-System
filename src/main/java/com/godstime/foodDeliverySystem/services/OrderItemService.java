package com.godstime.foodDeliverySystem.services;

import com.godstime.foodDeliverySystem.models.OrderItem;

import java.util.List;

public interface OrderItemService {
    OrderItem createOrderItem(OrderItem orderItem);
    OrderItem updateOrderItem(OrderItem orderItem);
    void deleteOrderItem(Long orderItemId);
    OrderItem getOrderItemById(Long orderItemId);
    List<OrderItem> getAllOrderItems();
    List<OrderItem> getOrderItemsByOrderId(Long orderId);
}
