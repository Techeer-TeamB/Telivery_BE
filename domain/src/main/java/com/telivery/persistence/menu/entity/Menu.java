package com.telivery.persistence.menu.entity;

import com.sun.istack.NotNull;
import com.telivery.common.domain.BaseEntity;
import com.telivery.persistence.category.entity.Category;
import com.telivery.persistence.restaurant.entity.Restaurant;
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
@Table(name = "menu")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Menu extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "restaurant_id")
  private Restaurant restaurant;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "category_id")
  private Category category;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "sub_category_id")
  private Category subCategory;

  @Column(length = 50)
  private String name;

  @NotNull
  private int price;

  @Column(length = 255)
  private String description;

  @Column(length = 255)
  private String photo;

  @Column(length = 30)
  private String status;

}
