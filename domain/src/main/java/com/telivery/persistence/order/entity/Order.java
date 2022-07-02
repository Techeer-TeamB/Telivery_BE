package com.telivery.persistence.order.entity;

import com.sun.istack.NotNull;
import com.telivery.common.domain.BaseEntity;
import com.telivery.persistence.category.entity.Category;
import com.telivery.persistence.restaurant.entity.Restaurant;
import com.telivery.persistence.user.entity.User;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "order")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Order extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id")
  private User user;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "restaurant_id")
  private Restaurant restaurant;

  @Column(length = 30)
  private Status status;

  @NotNull
  @Column(name = "total_price")
  private int totalPrice;

  @Builder
  public Order(User user, Restaurant restaurant, Status status, int totalPrice) {
    this.user = user;
    this.restaurant = restaurant;
    this.status = status;
    this.totalPrice = totalPrice;
  }
}
