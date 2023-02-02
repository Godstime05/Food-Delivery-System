package com.godstime.foodDeliverySystem.services;

import com.godstime.foodDeliverySystem.exceptions.ResourceNotFoundException;
import com.godstime.foodDeliverySystem.models.OrderItem;

import java.util.List;
import java.util.Map;

public interface OrderItemService {
    OrderItem createOrderItem(OrderItem orderItem);
    OrderItem updateOrderItem(Long orderItemId, OrderItem orderItemDetails) throws ResourceNotFoundException;
    abstract Map<String, Boolean> deleteOrderItem(Long orderItemId) throws ResourceNotFoundException;
    OrderItem getOrderItemById(Long orderItemId);
    List<OrderItem> getAllOrderItems();
    List<OrderItem> getOrderItemsByOrderId(Long orderId);
}
