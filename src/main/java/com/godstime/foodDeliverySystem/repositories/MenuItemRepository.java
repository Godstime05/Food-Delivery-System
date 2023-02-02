package com.godstime.foodDeliverySystem.repositories;

import com.godstime.foodDeliverySystem.models.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {


    Optional<MenuItem> findById(Long aLong);

    List<MenuItem> findByRestaurantId(Long restaurantId);
}
