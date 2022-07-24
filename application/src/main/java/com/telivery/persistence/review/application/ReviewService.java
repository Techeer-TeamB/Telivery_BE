package com.telivery.persistence.review.application;

import com.telivery.persistence.restaurant.application.RestaurantService;
import com.telivery.persistence.restaurant.entity.Restaurant;
import com.telivery.persistence.review.dao.ReviewRepository;
import com.telivery.persistence.review.dto.ReviewDTO.ReviewReq;
import com.telivery.persistence.review.dto.ReviewDTO.ReviewRes;
import com.telivery.persistence.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ReviewService {

  private final ReviewRepository reviewRepository;
  private final RestaurantService restaurantService;

  @Transactional(readOnly = true)
  public long countByRestaurantId(Long restaurantId) {
    return reviewRepository.countByRestaurantId(restaurantId);
  }

  @Transactional(readOnly = true)
  public ReviewRes create(User user, long restaurantId, long orderId, ReviewReq reviewReq) {
    Restaurant restaurant = restaurantService.findById(restaurantId);
    // DESCRIBE: orderId로 주문 내역 조회한 후, user로 크로스체크

  }

}
