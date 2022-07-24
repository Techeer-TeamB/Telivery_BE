package com.telivery.persistence.review.entity;

import com.telivery.common.domain.BaseEntity;
import com.telivery.persistence.order.entity.Order;
import com.telivery.persistence.order.entity.Status;
import com.telivery.persistence.restaurant.entity.Restaurant;
import com.telivery.persistence.user.entity.User;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.aspectj.weaver.ast.Or;

@Getter
@Entity
@Table(name = "review")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Review extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id")
  private User user;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "order_id")
  private Order order;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "restaurant_id")
  private Restaurant restaurant;

  @Column
  private String description;

  @Column
  private String photo;

  @Column
  private Float score;

  @Builder
  public Review(User user, Order order, Restaurant restaurant, String description, String photo,
      Float score) {
    this.user = user;
    this.order = order;
    this.restaurant = restaurant;
    this.description = description;
    this.photo = photo;
    this.score = score;
  }

}
