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
    private Float score;

    public Review toEntity(User user, Restaurant restaurant, Order order) {
      return Review.builder()
          .user(user)
          .order(order)
          .restaurant(restaurant)
          .description(description)
          .photo(photo)
          .score(score)
          .build();
    }

  }

  @Getter
  @NoArgsConstructor(access = AccessLevel.PROTECTED)
  public static class ReviewRes {

    private String userName;
    private Float score;
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
