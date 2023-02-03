package com.godstime.foodDeliverySystem.controllers;


import com.godstime.foodDeliverySystem.dto.ApiResponse;
import com.godstime.foodDeliverySystem.dto.request.MenuItemRequest;
import com.godstime.foodDeliverySystem.dto.response.MenuItemResponse;
import com.godstime.foodDeliverySystem.exceptions.BadRequestException;
import com.godstime.foodDeliverySystem.exceptions.ResourceNotFoundException;
import com.godstime.foodDeliverySystem.models.MenuItem;
import com.godstime.foodDeliverySystem.services.MenuItemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/menu-item")
public class MenuItemController {

    private final MenuItemService menuItemService;

    @Autowired
    public MenuItemController(MenuItemService menuItemService) {
        this.menuItemService = menuItemService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse> getAllMenuItems(@RequestParam(value = "restaurantId", required = false) Long restaurantId) {
        try {
            List<MenuItem> menuItems = menuItemService.getAllMenuItems();
            return new ResponseEntity<>(new ApiResponse(true, "All menu Items retrieved successfully", menuItems), HttpStatus.OK);
        } catch (ResourceNotFoundException ex) {
            return new ResponseEntity<>(new ApiResponse(false, ex.getMessage(), null), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse(false, "An error occurred while retrieving menu items", null),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
        // List<MenuItem> menuItems = menuItemService.getAllMenuItems();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MenuItemResponse> getMenuItemById(@PathVariable Long id) {
        MenuItem menuItemResponse = menuItemService.getMenuItemById(id);
             //   .orElseThrow(() -> new ResourceNotFoundException("Menu item", "id", id));
        return new ResponseEntity<>(new MenuItemResponse(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ApiResponse> addMenuItem(@Valid @RequestBody MenuItemRequest menuItemRequest, MenuItem menuItem,
                                                   BindingResult result) {
        if (result.hasErrors()) {
            throw new BadRequestException(result.getAllErrors().stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.joining(",")));
        }
        MenuItem menuItem1 = menuItemService.createMenuItem(menuItem);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(menuItem.getId()).toUri();
        return ResponseEntity.created(location)
                .body(new ApiResponse(true, "Menu item added successfully"));
    }
//

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> updateMenuItem(@PathVariable Long id,
                                                      @Valid @RequestBody MenuItemRequest menuItemRequest, MenuItem menuItem,
                                                      BindingResult result) {
        if (result.hasErrors()) {
            throw new BadRequestException(result.getAllErrors().stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.joining(",")));
        }
        menuItemService.updateMenuItem(menuItem);
        return new ResponseEntity<>(new ApiResponse(true, "Menu item updated successfully"), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteMenuItem(@PathVariable Long id) {
        menuItemService.deleteMenuItem(id);
        return new ResponseEntity<>(new ApiResponse(true, "Menu item deleted successfully"), HttpStatus.OK);
    }

//
}
//
//