package com.telivery.persistence.restaurant.application;

import com.telivery.common.exception.global.NoDataException;
import com.telivery.persistence.restaurant.dao.RestaurantRepository;
import com.telivery.persistence.restaurant.dto.RestaurantDTO;
import com.telivery.persistence.restaurant.dto.RestaurantInfoDTO;
import com.telivery.persistence.restaurant.entity.Restaurant;
import com.telivery.persistence.restaurant.exception.RestaurantIdNotFoundException;
import com.telivery.persistence.review.application.ReviewService;
import com.telivery.persistence.time.application.TimeService;
import com.telivery.persistence.time.dto.TimeDTO;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RestaurantService {

  private final TimeService timeService;
  private final ReviewService reviewService;
  private final RestaurantRepository restaurantRepository;

  public Restaurant findById(long restaurantId) {
    Restaurant restaurant = restaurantRepository.findById(restaurantId).orElseThrow(
        RestaurantIdNotFoundException::new);
    return restaurant;
  }

  public RestaurantDTO getRestaurantInfo(long restaurantId) {
    Restaurant restaurant = restaurantRepository.findById(restaurantId).orElseThrow(
        NoDataException::new);
    TimeDTO workHour = timeService.findOneByRestaurantId(restaurantId);
    Long reviewCount = reviewService.countByRestaurantId(restaurantId);

    return RestaurantDTO.builder().restaurant(restaurant).workHour(workHour).reviewCount(reviewCount).build();
  }

  @Cacheable(value="restaurants", key = "#categoryId", unless="#result == null")
  public List<Restaurant> findByCategory(long categoryId) {
    List<Restaurant> restaurants = restaurantRepository.findByCategoryId(categoryId);
    if (restaurants.isEmpty()) throw new NoDataException();
    return restaurants;
  }

  public List<RestaurantInfoDTO> findRestarurantsByCategory(long categoryId) {
    List<RestaurantInfoDTO> restaurantInfoDTOs = new ArrayList<>();
    List<Restaurant> restaurants = findByCategory(categoryId);

    for (Restaurant restaurant : restaurants) {
      long reviewCount = reviewService.countByRestaurantId(restaurant.getId());
      restaurantInfoDTOs.add(RestaurantInfoDTO.builder().restaurant(restaurant).reviewCount(reviewCount).build());
    }

    return restaurantInfoDTOs;
  }

}
