package com.telivery.persistence.restaurant.entity;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.telivery.common.domain.BaseEntity;
import com.telivery.persistence.category.entity.Category;
import javax.persistence.Column;
import javax.persistence.Embedded;
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

@Getter
@Entity
@Table(name = "restaurant")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Restaurant extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "category_id")
  private Category category;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "sub_category_id")
  private Category subCategory;

  @Column(length = 50)
  private String name;

  @Column(length = 13)
  private String phone;

  @Column
  private String description;

  @Column
  private String photo;

  @Column
  private Float score;

  @Column(name = "delivery_fee")
  private Integer deliveryFee;

  @Column(name = "min_order")
  private Integer minOrder;

  @Embedded
  private Address address;

  @Builder
  public Restaurant(Category category, Category subCategory, String name, String phone,
      Address address, String description, Float score, String photo, Integer deliveryFee,
      Integer minOrder) {
    this.category = category;
    this.subCategory = subCategory;
    this.name = name;
    this.phone = phone;
    this.address = address;
    this.description = description;
    this.score = score;
    this.photo = photo;
    this.deliveryFee = deliveryFee;
    this.minOrder = minOrder;
  }

  public void updateScore(Float reviewScore, long reviewCnt) {
    this.score = (reviewCnt == 0) ? reviewScore : (score * reviewCnt + reviewScore) / (reviewCnt - 1);
  }


}
