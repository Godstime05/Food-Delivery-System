package com.godstime.foodDeliverySystem.repositories;

import com.godstime.foodDeliverySystem.models.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    List<Restaurant> findByName(String name);
}
