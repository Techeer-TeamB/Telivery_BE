package com.telivery.persistence.restaurant.application;

import com.telivery.common.exception.global.NoDataException;
import com.telivery.persistence.restaurant.dao.RestaurantRepository;
import com.telivery.persistence.restaurant.dto.RestaurantDTO;
import com.telivery.persistence.restaurant.entity.Restaurant;
import com.telivery.persistence.review.application.ReviewService;
import com.telivery.persistence.time.application.TimeService;
import com.telivery.persistence.time.dto.TimeDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RestaurantService {

  private final TimeService timeService;
  private final ReviewService reviewService;
  private final RestaurantRepository restaurantRepository;

  public RestaurantDTO getRestaurantInfo(Long restaurantId) {
    Restaurant restaurant = restaurantRepository.findById(restaurantId).orElseThrow(
        NoDataException::new);
    TimeDTO workHour = timeService.findOneByRestaurantId(restaurantId);
    Long reviewCount = reviewService.countByRestaurantId(restaurantId);

    return new RestaurantDTO(restaurant, workHour, reviewCount);
  }

}
