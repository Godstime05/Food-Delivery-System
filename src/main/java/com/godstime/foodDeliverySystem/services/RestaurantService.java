package com.godstime.foodDeliverySystem.services;

import com.godstime.foodDeliverySystem.models.Restaurant;

import java.util.List;

public interface RestaurantService {
    Restaurant createRestaurant(Restaurant restaurant);
    Restaurant updateRestaurant(Restaurant restaurant);
    void deleteRestaurant(Long restaurantId);
    Restaurant getRestaurantById(Long restaurantId);
    List<Restaurant> getAllRestaurants();
    List<Restaurant> searchRestaurants(String name);
}

