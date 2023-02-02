package com.godstime.foodDeliverySystem.controllers;

import com.godstime.foodDeliverySystem.dto.ApiResponse;
import com.godstime.foodDeliverySystem.dto.request.RestaurantRequest;
import com.godstime.foodDeliverySystem.exceptions.ResourceNotFoundException;
import com.godstime.foodDeliverySystem.models.Restaurant;
import com.godstime.foodDeliverySystem.services.RestaurantService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {
    @Autowired
    private RestaurantService restaurantService;


    @PostMapping("/register")
    public ResponseEntity<ApiResponse> registerRestaurant(@Valid @RequestBody RestaurantRequest restaurantRequest){
        Restaurant restaurant = restaurantService.registerRestaurant(restaurantRequest);
        ApiResponse response = new ApiResponse(true, "Restaurant registered successfully");
        response.setData(restaurant);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{restaurantId}")
    public ResponseEntity<ApiResponse>getRestaurantById(@PathVariable Long restaurantId){
        Restaurant restaurant = restaurantService.getRestaurantById(restaurantId);
//                .orElseThrow(() -> new ResourceNotFoundException("Restaurant", "id", restaurantId));
        ApiResponse response = new ApiResponse(true, "Restaurant found successfully");
        response.setData(restaurant);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<ApiResponse> searchRestaurant(@RequestParam(value = "name") String name, String address) {
        List<Restaurant> restaurants = restaurantService.searchRestaurants(name, address);
        if (restaurants.isEmpty()){
            throw new ResourceNotFoundException("Restaurant", "name", name);
        }
        ApiResponse  response = new ApiResponse(true, "Restaurant(s) found successfully");
        response.setData(restaurants);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}

