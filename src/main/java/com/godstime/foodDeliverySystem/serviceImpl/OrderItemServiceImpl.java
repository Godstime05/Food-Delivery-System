package com.godstime.foodDeliverySystem.serviceImpl;

import com.godstime.foodDeliverySystem.models.OrderItem;
import com.godstime.foodDeliverySystem.services.OrderItemService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemServiceImpl implements OrderItemService {
    @Override
    public OrderItem createOrderItem(OrderItem orderItem) {
        return null;
    }

    @Override
    public OrderItem updateOrderItem(OrderItem orderItem) {
        return null;
    }

    @Override
    public void deleteOrderItem(Long orderItemId) {

    }

    @Override
    public OrderItem getOrderItemById(Long orderItemId) {
        return null;
    }

    @Override
    public List<OrderItem> getAllOrderItems() {
        return null;
    }

    @Override
    public List<OrderItem> getOrderItemsByOrderId(Long orderId) {
        return null;
    }
}
//
//    @Autowired
//    private FoodItemRepository foodItemRepository;
//
//    @Override
//    public FoodItem createFoodItem(FoodItem foodItem) {
//        if (foodItem == null) {
//            throw new IllegalArgumentException("Food item cannot be null");
//        }
//        return foodItemRepository.save(foodItem);
//    }
//
//    @Override
//    public FoodItem updateFoodItem(FoodItem foodItem) {
//        if (foodItem == null) {
//            throw new IllegalArgumentException("Food item cannot be null");
//        }
//        if (foodItem.getId() == null) {
//            throw new IllegalArgumentException("Food item id cannot be null");
//        }
//        Optional<FoodItem> existingFoodItem = foodItemRepository.findById(foodItem.getId());
//        if (!existingFoodItem.isPresent()) {
//            throw new EntityNotFoundException("Food item with id " + foodItem.getId() + " not found");
//        }
//        return foodItemRepository.save(foodItem);
//    }
//
//    @Override
//    public FoodItem getFoodItemById(Long foodItemId) {
//        if (foodItemId == null) {
//            throw new IllegalArgumentException("Food item id cannot be null");
//        }
//        Optional<FoodItem> foodItem = foodItemRepository.findById(foodItemId);
//        if (!foodItem.isPresent()) {
//            throw new EntityNotFoundException("Food item with id " + foodItemId + " not found");
//        }
//        return foodItem.get();
//    }
//
//    @Override
//    public void deleteFoodItem(Long foodItemId) {
//        if (foodItemId == null) {
//            throw new IllegalArgumentException("Food item id cannot be null");
//        }
//        foodItemRepository.deleteById(foodItemId);
//    }
//}
