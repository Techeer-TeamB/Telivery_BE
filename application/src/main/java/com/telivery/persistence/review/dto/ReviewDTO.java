package com.telivery.persistence.review.dto;

import com.telivery.persistence.order.entity.Order;
import com.telivery.persistence.restaurant.entity.Restaurant;
import com.telivery.persistence.review.entity.Review;
import com.telivery.persistence.user.entity.User;
import java.util.List;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class ReviewDTO {

  @Getter
  @NoArgsConstructor(access = AccessLevel.PROTECTED)
  public static class ReviewReq {

    private String description;
    private String photo;
    private Integer score;

    public Review toEntity(User user, Order order, Restaurant restaurant, ReviewReq reviewReq) {
      return Review.builder()
          .user(user)
          .order(order)
          .restaurant(restaurant)
          .description(reviewReq.getDescription())
          .photo(reviewReq.getPhoto())
          .score(reviewReq.getScore())
          .build();
    }

  }

  @Getter
  @NoArgsConstructor(access = AccessLevel.PROTECTED)
  public static class ReviewRes {

    private String userName;
    private Integer score;
    private String description;
    private List<String> orderList;

    @Builder
    public ReviewRes(Review review, List<String> orderList) {
      this.userName = review.getUser().getName();
      this.score = review.getScore();
      this.description = review.getDescription();
      this.orderList = orderList;
    }
  }

}