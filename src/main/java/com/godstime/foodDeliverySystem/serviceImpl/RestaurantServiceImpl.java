package com.godstime.foodDeliverySystem.serviceImpl;


import com.godstime.foodDeliverySystem.dto.request.RestaurantRequest;
import com.godstime.foodDeliverySystem.models.Restaurant;
import com.godstime.foodDeliverySystem.repositories.RestaurantRepository;
import com.godstime.foodDeliverySystem.services.RestaurantService;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RestaurantServiceImpl implements RestaurantService {
    @Autowired
    private RestaurantRepository restaurantRepository;

      //  private final RestaurantRepository restaurantRepository;

    @Override
    public Restaurant registerRestaurant(@Valid RestaurantRequest restaurant) {

        if (restaurant == null) {
            throw new IllegalArgumentException("Restaurant cannot be null");
        }
        if (restaurant.getName() == null || restaurant.getName().isEmpty()) {
            throw new IllegalArgumentException("Restaurant name cannot be null or empty");
        }
        Optional<Restaurant> existingRestaurant = restaurantRepository.findById(restaurant.getId());
        if (existingRestaurant.isPresent()) {
            throw new EntityExistsException("Restaurant with name " + restaurant.getName() + " already exists");
        }

        if (restaurant.getAddress() == null) {
            throw new IllegalArgumentException("Address is a required field");
        }
        if (restaurant.getPhoneNo() == null) {
            throw new IllegalArgumentException("Phone is a required field");
        }
        return restaurantRepository.save(registerRestaurant(restaurant));

    }

    @Override
    public Restaurant updateRestaurant(Restaurant restaurant) {

        if (restaurant == null) {
            throw new IllegalArgumentException("Restaurant cannot be null");
        }
        if (restaurant.getId() == null) {
            throw new IllegalArgumentException("Restaurant id is a required field");
        }
        if (restaurant.getName() == null) {
            throw new IllegalArgumentException("Name is a required field");
        }
        if (restaurant.getAddress() == null) {
            throw new IllegalArgumentException("Address is a required field");
        }
        if (restaurant.getPhoneNo() == null) {
            throw new IllegalArgumentException("Phone is a required field");
        }
        Optional<Restaurant> existingRestaurant = restaurantRepository.findById(restaurant.getId());
        if (existingRestaurant.isEmpty()) {
            throw new EntityNotFoundException("Restaurant with id " + restaurant.getId() + " not found");
        }
        return restaurantRepository.save(restaurant);
    }

    @Override
    public void deleteRestaurant(Long restaurantId) {
        if (restaurantId == null) {
            throw new IllegalArgumentException("Restaurant id cannot be null");
        }
        if (!restaurantRepository.existsById(restaurantId)) {
            throw new EntityNotFoundException("Restaurant with id " + restaurantId + " not found");
        }
        restaurantRepository.deleteById(restaurantId);
    }

    @Override
    public Restaurant getRestaurantById(Long restaurantId) {
        if (restaurantId == null) {
            throw new IllegalArgumentException("Restaurant id cannot be null");
        }
        Optional<Restaurant> restaurant = restaurantRepository.findById(restaurantId);
        if (restaurant.isEmpty()) {
            throw new EntityNotFoundException("Restaurant with id " + restaurantId + " not found");
        }
       // return restaurant.get();
        return restaurantRepository.findById(restaurantId).orElseThrow(() ->
               new EntityNotFoundException("Restaurant with id " + restaurantId + " not found"));
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }


    @Override
    public List<Restaurant> searchRestaurants(String name, String address) {
        List<Restaurant> restaurants = new ArrayList<>();
        if (name == null && address == null) {
            restaurants = restaurantRepository.findAll();
        } else {
            restaurants = restaurantRepository.findByNameAndAddress(
                    name != null ? name : "", address != null ? address : "");
        }
        return restaurants;

    }
}

//
//