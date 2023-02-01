package com.godstime.foodDeliverySystem.serviceImpl;

import com.godstime.foodDeliverySystem.models.MenuItem;
import com.godstime.foodDeliverySystem.models.Order;
import com.godstime.foodDeliverySystem.repositories.CustomerRepository;
import com.godstime.foodDeliverySystem.repositories.MenuItemRepository;
import com.godstime.foodDeliverySystem.repositories.OrderRepository;
import com.godstime.foodDeliverySystem.repositories.RestaurantRepository;
import com.godstime.foodDeliverySystem.services.OrderService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private MenuItemRepository menuItemRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    public Order createOrder(Order order) {

        List<MenuItem> menuItems = order.getMenuItems();
        double totalPrice = 0;
        for (MenuItem menuItem : menuItems) {
            totalPrice += menuItem.getPrice();
        }
        order.setTotalPrice(totalPrice);

        // save the order to the database
        Order savedOrder = orderRepository.save(order);

        // update the stock of the menu items
        for (MenuItem menuItem : menuItems) {
            MenuItem savedMenuItem = menuItemRepository.getOne(menuItem.getId());
            savedMenuItem.setPrice(savedMenuItem.getPrice() - 1);
            menuItemRepository.save(savedMenuItem);

        }


        if (order == null){
            throw new IllegalArgumentException("order cannot be null");
        }
        if (order.getCustomer() == null){
            throw new IllegalArgumentException("Customer is a required field");
        }
        if (order.getRestaurant() == null){
            throw new IllegalArgumentException("Restaurant is a required field");
        }
        if (order.getFoodItems() == null  || order.getFoodItems().isEmpty()){
            throw new IllegalArgumentException("Food Items are a required field");
        }
        if (!customerRepository.existsById(Long.valueOf(order.getCustomer().getId()))){
            throw new IllegalArgumentException("Customer with id"+order.getCustomer().getId()+"not found");
        }
        if (!restaurantRepository.existsById(order.getRestaurant().getId())){
            throw new IllegalArgumentException("Restaurant with id " + order.getCustomer().getId() + " not found");
        }
        return  savedOrder;

    }

    @Override
    public Order updateOrder(Order order) {
        if (order == null){
            throw new IllegalArgumentException("Order cannot be null");
        }
        if (order.getId() == null){
            throw new IllegalArgumentException("Order is a required field");
        }
        if (order.getCustomer() == null){
            throw new IllegalArgumentException("Customer can not be null");
        }
        if (order.getRestaurant() == null){
            throw new IllegalArgumentException("Restaurant is a required field");
        }
        if (order.getFoodItems() == null || order.getFoodItems().isEmpty()) {
            throw new IllegalArgumentException("Food items are a required field");
        }
        if (!customerRepository.existsById(Long.valueOf(order.getCustomer().getId()))) {
            throw new EntityNotFoundException("Customer with id " + order.getCustomer().getId() + " not found");
        }
        if (!restaurantRepository.existsById(order.getRestaurant().getId())) {
            throw new EntityNotFoundException("Restaurant with id " + order.getRestaurant().getId() + " not found");
        }
        return orderRepository.save(order);

    }

    @Override
    public void deleteOrder(Long orderId) {

        if (orderId == null) {
            throw new IllegalArgumentException("Order id cannot be null");
        }
        if (!orderRepository.existsById(orderId)) {
            throw new EntityNotFoundException("Order with id " + orderId + " not found");
        }
        orderRepository.deleteById(orderId);
    }

    @Override
    public Order getOrderById(Long orderId) {
        if (orderId == null){
            throw new IllegalArgumentException("Order id cannot be null");
        }
        Optional<Order> order= orderRepository.findById(orderId);
        if (!order.isPresent()){
            throw new EntityNotFoundException("Order with id " + orderId + "not found");
        }
        return order.get();
    }
    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public List<Order> getOrdersByCustomerId(Long customerId) {
        if (customerId == null){
            throw new IllegalArgumentException("Customer id cannot be null");
        }
        if (!customerRepository.existsById(customerId)){
            throw new EntityNotFoundException("Customer with id " +customerId + "not fopund");
        }
        return orderRepository.findByCustomerId(customerId);
    }


//
//

}
