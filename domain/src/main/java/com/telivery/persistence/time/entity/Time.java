package com.telivery.persistence.time.entity;

import com.telivery.common.domain.BaseEntity;
import com.telivery.persistence.restaurant.entity.Restaurant;
import java.time.LocalDateTime;
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

@Getter
@Entity
@Table(name = "time")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Time extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "restaurant_id")
  private Restaurant restaurant;

  @Column(name = "open_time")
  private LocalDateTime openTime;

  @Column(name = "close_time")
  private LocalDateTime closeTime;

  @Column(name = "break_start_time")
  private LocalDateTime breakStartTime;

  @Column(name = "break_end_time")
  private LocalDateTime breakEndTime;

  @Builder
  public Time(Restaurant restaurant, LocalDateTime openTime, LocalDateTime closeTime,
      LocalDateTime breakStartTime, LocalDateTime breakEndTime ) {
    this.restaurant = restaurant;
    this.openTime = openTime;
    this.closeTime = closeTime;
    this.breakStartTime = breakStartTime;
    this.breakEndTime = breakEndTime;
  }

}
