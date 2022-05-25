package com.telivery.persistence.category.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CategoryMapperTest {

  private Long id;
  private String name;

  @Builder
  public CategoryMapperTest(Long id, String name) {
    this.id = id;
    this.name = name;
  }

}
