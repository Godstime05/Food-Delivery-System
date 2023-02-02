package com.godstime.foodDeliverySystem.controllers;

import com.godstime.foodDeliverySystem.dto.ApiResponse;
import com.godstime.foodDeliverySystem.exceptions.ResourceNotFoundException;
import com.godstime.foodDeliverySystem.models.MenuItem;
import com.godstime.foodDeliverySystem.services.MenuItemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/menu")
public class MenuItemController {

    @Autowired
    private MenuItemService menuItemService;
}
//    @GetMapping("/{restaurantId}")
//    public ResponseEntity<ApiResponse<List<MenuItem>>> getAllMenuItems(@PathVariable Long restaurantId) {
//        try {
//            List<MenuItem> menuItems = menuItemService.getAllMenuItems();
//            if (menuItems.isEmpty()) {
//                return new ResponseEntity<>(new ApiResponse<>(HttpStatus.NO_CONTENT.value(), "No menu item found for the restaurant", null),
//                        HttpStatus.NO_CONTENT);
//            }
//            List<MenuItemDto> menuItemDtos = menuItems.stream().map(menuItem -> {
//                return new MenuItemDto(menuItem.getId(), menuItem.getName(), menuItem.getDescription(), menuItem.getPrice());
//            }).collect(Collectors.toList());
//            return new ResponseEntity<>(new ApiResponse<>(HttpStatus.OK.value(), "Success", menuItemDtos), HttpStatus.OK);
//        } catch (ResourceNotFoundException ex) {
//            return new ResponseEntity<>(new ApiResponse<>(HttpStatus.NOT_FOUND.value(), ex.getMessage(), null), HttpStatus.NOT_FOUND);
//        } catch (Exception ex) {
//            return new ResponseEntity<>(new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage(), null), HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @PostMapping("/{restaurantId}")
//    public ResponseEntity<ApiResponse<MenuItemDto>> createMenuItem(@PathVariable Long restaurantId, @Valid @RequestBody MenuItemRequest menuItemRequest) {
//        try {
//            MenuItem menuItem = menuItemService.createMenuItem(restaurantId, menuItemRequest);
//            return new ResponseEntity<>(new ApiResponse<>(HttpStatus.OK.value(), "Success", new MenuItemDto(menuItem.getId(), menuItem.getName(), menuItem.getDescription(), menuItem.getPrice())), HttpStatus.OK);
//        } catch (BadRequestException ex) {
//            return new ResponseEntity<>(new ApiResponse<>(HttpStatus.BAD_REQUEST.value(), ex.getMessage(), null), HttpStatus.BAD_REQUEST);
//        } catch (ResourceNotFoundException ex) {
//            return new ResponseEntity<>(new ApiResponse<>(HttpStatus.NOT_FOUND.value(), ex.getMessage(), null), HttpStatus.NOT_FOUND);
//        } catch (Exception ex) {
//            return new ResponseEntity<>(new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage(), null), HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @PutMapping("/{menuItemId}")
//    public ResponseEntity<ApiResponse<MenuItemDto>> updateMenuItem(@PathVariable Long menuItemId, @Valid @RequestBody MenuItemRequest menuItemRequest)
