package com.godstime.foodDeliverySystem.services;

import com.godstime.foodDeliverySystem.models.MenuItem;

import java.util.List;

public interface MenuItemService {
    MenuItem createMenuItem(MenuItem menuItem);
    MenuItem updateMenuItem(MenuItem menuItem);
    void deleteMenuItem(Long menuItemId);
    MenuItem getMenuItemById(Long menuItemId);
    List<MenuItem> getAllMenuItems();
    List<MenuItem> getMenuItemsByRestaurantId(Long restaurantId);
}

