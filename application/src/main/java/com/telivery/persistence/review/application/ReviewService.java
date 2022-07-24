package com.telivery.persistence.review.application;

import com.telivery.persistence.order.application.OrderService;
import com.telivery.persistence.order.entity.Order;
import com.telivery.persistence.restaurant.application.RestaurantService;
import com.telivery.persistence.restaurant.entity.Restaurant;
import com.telivery.persistence.review.dao.ReviewRepository;
import com.telivery.persistence.review.dto.ReviewDTO.ReviewReq;
import com.telivery.persistence.review.dto.ReviewDTO.ReviewRes;
import com.telivery.persistence.review.entity.Review;
import com.telivery.persistence.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ReviewService {

  private final ReviewRepository reviewRepository;
  private final RestaurantService restaurantService;
  private final OrderService orderService;

  @Transactional(readOnly = true)
  public long countByRestaurantId(Long restaurantId) {
    return reviewRepository.countByRestaurantId(restaurantId);
  }

  @Transactional(readOnly = true)
  public ReviewRes create(User user, long restaurantId, long orderId, ReviewReq reviewReq) {
    Restaurant restaurant = restaurantService.findById(restaurantId);
    Order order = orderService.findByIdAndUser(orderId, user.getId());
    Review review = reviewReq.toEntity(user, restaurant, order);

    // DESCRIBE: 리뷰 생성
    reviewRepository.save(review);

    // DESCRIBE: 생성한 리뷰의 평점을 이용, 가게 평점 업데이트

    // DESCRIBE: 주문 메뉴 리스트 생성


    return new ReviewRes(review);
  }

}
