package com.godstime.foodDeliverySystem.services;

import com.godstime.foodDeliverySystem.models.Order;

import java.util.List;

public interface OrderService {
    Order createOrder(Order order);
    Order updateOrder(Order order);
    void deleteOrder(Long orderId);
    Order getOrderById(Long orderId);
    List<Order> getAllOrders();
    List<Order> getOrdersByCustomerId(Long customerId);
}

