package com.telivery.persistence.restaurant.entity;

import javax.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Address {

  private String address;

  @Builder
  public Address(String address) {
    this.address = address;
  }

}
