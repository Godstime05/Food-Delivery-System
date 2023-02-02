package com.godstime.foodDeliverySystem.serviceImpl;


import com.godstime.foodDeliverySystem.exceptions.BadRequestException;
import com.godstime.foodDeliverySystem.exceptions.ResourceNotFoundException;
import com.godstime.foodDeliverySystem.models.MenuItem;
import com.godstime.foodDeliverySystem.repositories.MenuItemRepository;
import com.godstime.foodDeliverySystem.services.MenuItemService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MenuItemServiceImpl implements MenuItemService {

    private final MenuItemRepository menuItemRepository;

    @Autowired
    public MenuItemServiceImpl(MenuItemRepository menuItemRepository) {
        this.menuItemRepository = menuItemRepository;
    }

    @Override
    public List<MenuItem> getMenuItemsByRestaurantId(Long restaurantId) {
        return (List<MenuItem>) menuItemRepository.findById(restaurantId)
                .orElseThrow(() -> new ResourceNotFoundException("No menu items found for restaurant with id " + restaurantId));
    }

    @Override
    public MenuItem createMenuItem(MenuItem menuItem) {
        if (menuItem.getId() != null) {
            throw new BadRequestException("Id should not be set while adding a new menu item");
        }
        return menuItemRepository.save(menuItem);
    }
    @Override
    public MenuItem updateMenuItem(MenuItem menuItem) {
        if (menuItem.getId() == null) {
            throw new BadRequestException("Id should be set while updating a menu item");
        }
        return menuItemRepository.findById(menuItem.getId())
                .map(existingMenuItem -> {
                    existingMenuItem.setName(menuItem.getName());
                    existingMenuItem.setDescription(menuItem.getDescription());
                    existingMenuItem.setPrice(menuItem.getPrice());
                    return menuItemRepository.save(existingMenuItem);
                })
                .orElseThrow(() -> new ResourceNotFoundException("No menu item found with id " + menuItem.getId()));
    }
    @Override
    public void deleteMenuItem(Long id) {
        if (!menuItemRepository.existsById(id)) {
            throw new ResourceNotFoundException("No menu item found with id " + id);
        }
        menuItemRepository.deleteById(id);
    }
    @Override
    public MenuItem getMenuItemById(Long menuItemId) {
        if (menuItemId == null){
            throw new IllegalArgumentException("Menu item Id cannot be null");
        }
        Optional<MenuItem> menuItem = menuItemRepository.findById(menuItemId);
        if (!menuItem.isPresent()){
            throw new EntityNotFoundException("Menu item with id " + menuItemId + "not found");
        }
        return menuItem.get();
    }
    @Override
    public List<MenuItem> getAllMenuItems() {
        return null;
    }
//
}
