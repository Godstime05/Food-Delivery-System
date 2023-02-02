package com.godstime.foodDeliverySystem.services;

import com.godstime.foodDeliverySystem.dto.request.RestaurantRequest;
import com.godstime.foodDeliverySystem.models.Restaurant;
import jakarta.validation.Valid;

import java.util.List;

public interface RestaurantService {
    Restaurant registerRestaurant(@Valid RestaurantRequest restaurant);
    Restaurant updateRestaurant(Restaurant restaurant);
    void deleteRestaurant(Long restaurantId);
    Restaurant getRestaurantById(Long restaurantId);
    List<Restaurant> getAllRestaurants();
    List<Restaurant> searchRestaurants(String name, String address);
}

