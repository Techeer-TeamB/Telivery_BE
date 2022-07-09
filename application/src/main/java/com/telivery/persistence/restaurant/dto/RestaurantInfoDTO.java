package com.telivery.persistence.restaurant.dto;

import com.telivery.persistence.restaurant.entity.Restaurant;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RestaurantInfoDTO {

  private long id;
  private String name;
  private float score;
  private long reviewCount;
  private int minPrice;
  private int deliveryFee;
  private String photo;

  @Builder
  public RestaurantInfoDTO(Restaurant restaurant, long reviewCount) {
    this.id = restaurant.getId();
    this.name = restaurant.getName();
    this.score = restaurant.getScore();
    this.reviewCount = reviewCount;
    this.minPrice = restaurant.getMinOrder();;
    this.deliveryFee = restaurant.getDeliveryFee();;
    this.photo = restaurant.getPhoto();
  }

}
