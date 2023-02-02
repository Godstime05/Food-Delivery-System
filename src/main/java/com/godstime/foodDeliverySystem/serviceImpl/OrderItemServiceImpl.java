package com.godstime.foodDeliverySystem.serviceImpl;

import com.godstime.foodDeliverySystem.exceptions.BadRequestException;
import com.godstime.foodDeliverySystem.exceptions.ResourceNotFoundException;
import com.godstime.foodDeliverySystem.models.OrderItem;
import com.godstime.foodDeliverySystem.repositories.OrderItemRepository;
import com.godstime.foodDeliverySystem.services.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderItemServiceImpl implements OrderItemService {

    private final OrderItemRepository orderItemRepo;

    @Autowired
    public OrderItemServiceImpl(OrderItemRepository orderItemRepo) {
        this.orderItemRepo = orderItemRepo;
    }

    @Override
    public OrderItem createOrderItem(OrderItem orderItem) throws ResourceNotFoundException{
        if (orderItem.getId() != null){
            throw new BadRequestException("Id field must be empty for new order Item");
        }
        return orderItemRepo.save(orderItem);
    }

    @Override
    public OrderItem updateOrderItem(Long orderItemId, OrderItem orderItemDetails) throws ResourceNotFoundException {
        OrderItem orderItem = orderItemRepo.findById(orderItemId)
                .orElseThrow(() -> new ResourceNotFoundException("orderItem not found with id "+ orderItemId));
        orderItem.setOrder(orderItemDetails.getOrder());
        orderItem.setDescription(orderItemDetails.getDescription());
        orderItem.setQuantity(orderItemDetails.getQuantity());

        return orderItemRepo.save(orderItem);
    }

//    @Override
//    public void deleteOrderItem(Long orderItemId) {
//
//    }

    @Override
    public OrderItem getOrderItemById(Long orderItemId) {
        return (OrderItem) orderItemRepo.findById(orderItemId).orElseThrow(() ->
                new ResourceNotFoundException("Order Item not found with id"+ orderItemId));
    }

    @Override
    public List<OrderItem> getAllOrderItems() {
        return orderItemRepo.findAll();
    }

    @Override
    public List<OrderItem> getOrderItemsByOrderId(Long orderId) throws ResourceNotFoundException {

        return (List<OrderItem>) orderItemRepo.findByOrderId(orderId);
    }

  @Override
  public Map<String, Boolean> deleteOrderItem(Long orderItemId) throws ResourceNotFoundException {
    OrderItem orderItem = orderItemRepo.findById(orderItemId).orElseThrow(() -> new ResourceNotFoundException("OrderItem not found with id " + orderItemId));

    orderItemRepo.delete(orderItem);

    Map<String, Boolean> response = new HashMap<>();
    response.put("deleted", Boolean.TRUE);
    return response;
  }
}


