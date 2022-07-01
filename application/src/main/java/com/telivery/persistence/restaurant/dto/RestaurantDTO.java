package com.telivery.persistence.restaurant.dto;

import com.telivery.persistence.restaurant.entity.Restaurant;
import com.telivery.persistence.time.dto.TimeDTO;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RestaurantDTO {

  private long id;
  private String name;
  private float score;
  private long reviewCount;
  private int minPrice;
  private int deliveryFee;
  private String photo;
  private String phone;
  private String address;
  private TimeDTO workHour;

  @Builder
  public RestaurantDTO(Restaurant restaurant, TimeDTO workHour, Long reviewCount) {
    this.id = restaurant.getId();
    this.name = restaurant.getName();
    this.score = restaurant.getScore();
    this.reviewCount = reviewCount;
    this.minPrice = restaurant.getMinOrder();
    this.deliveryFee = restaurant.getDeliveryFee();
    this.photo = restaurant.getPhoto();
    this.phone = restaurant.getPhone();
    this.address = restaurant.getAddress().getAddress();
    this.workHour = workHour;
  }

}
