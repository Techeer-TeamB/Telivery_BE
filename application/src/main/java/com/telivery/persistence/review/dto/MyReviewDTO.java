package com.telivery.persistence.review.dto;

import com.telivery.persistence.review.entity.Review;
import java.util.List;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class MyReviewDTO {

  @Getter
  @NoArgsConstructor(access = AccessLevel.PROTECTED)
  public static class MyReviewRes {

    private String date;
    private List<MyReviewInfo> reviewList;

    @Builder
    public MyReviewRes(String date, List<MyReviewInfo> reviewList) {
      this.date = date;
      this.reviewList = reviewList;
    }

  }

  @Getter
  @NoArgsConstructor(access = AccessLevel.PROTECTED)
  public static class MyReviewInfo {

    private Float score;
    private String restaurantName;
    private String description;
    private List<String> orderList;

    @Builder
    public MyReviewInfo(Review review, List<String> orderList, String restaurantName) {
      this.score = review.getScore();
      this.restaurantName = restaurantName;
      this.description = review.getDescription();
      this.orderList = orderList;
    }

  }


}
