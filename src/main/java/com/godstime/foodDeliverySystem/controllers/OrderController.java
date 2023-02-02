package com.godstime.foodDeliverySystem.controllers;

import com.godstime.foodDeliverySystem.dto.ApiResponse;
import com.godstime.foodDeliverySystem.dto.response.OrderResponse;
import com.godstime.foodDeliverySystem.exceptions.ResourceNotFoundException;
import com.godstime.foodDeliverySystem.models.Order;
import com.godstime.foodDeliverySystem.repositories.OrderRepository;
import com.godstime.foodDeliverySystem.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService orderService;
    private final OrderRepository orderRepository;

    @Autowired
    public OrderController(OrderService orderService,
                           OrderRepository orderRepository) {
        this.orderService = orderService;
        this.orderRepository = orderRepository;
    }

    @PostMapping
    public ResponseEntity<ApiResponse>createOrder(@RequestBody Order orderRequest, BindingResult result){
        if (result.hasErrors()){
            return new ResponseEntity<>(new ApiResponse(false, "Validation error", result.getAllErrors()),
                    HttpStatus.BAD_REQUEST);
        }
        Order order = orderService.createOrder(orderRequest);
        return new ResponseEntity<>(new ApiResponse(true, "Order created successfully", order),HttpStatus.CREATED);
    }

    @GetMapping
    public List <OrderResponse>getAllOrders(){
        List<Order>orders = orderService.getAllOrders();
        return orders.stream()
                .map(OrderResponse::new)
                .collect(Collectors.toList());
    }
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getOrderById(@PathVariable(value = "id") Long orderId) {
        Order order = orderService.getOrderById(orderId);
        return new ResponseEntity<>(new ApiResponse(true,"Order Retrieved successfully", new OrderResponse(order)),
                HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> updateOrder(@PathVariable(value = "id") Long orderId,
                                                   @RequestBody Order orderRequest,
                                                   BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<>(new ApiResponse(false, "Validation Error",
                                                        result.getAllErrors()),
                                        HttpStatus.BAD_REQUEST);
        }
        Order order = orderService.updateOrder(orderRequest);
              //  .orElseThrow(() -> new ResourceNotFoundException("Order", "id", orderId));
        return new ResponseEntity<>(new ApiResponse(true, "Order updated successfully",
                                                    new OrderResponse(order)), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ApiResponse>deleteOrder(@PathVariable(value = "id") Long orderId){
        orderService.deleteOrder(orderId);
        return  new ResponseEntity<>(new ApiResponse(true, "Order deleted successfully"), HttpStatus.OK);
    }
}
//
