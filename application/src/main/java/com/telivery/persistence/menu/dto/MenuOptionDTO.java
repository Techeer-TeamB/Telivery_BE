package com.telivery.persistence.menu.dto;

import com.telivery.persistence.menu.entity.MenuOption;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class MenuOptionDTO {

  @Getter
  @NoArgsConstructor(access = AccessLevel.PROTECTED)
  public static class MenuOptionReq {
    // DESCRIBE: 지금 안쓰니까 생략
  }

  @Getter
  @NoArgsConstructor(access = AccessLevel.PROTECTED)
  public static class MenuOptionRes {
    private Long id;
    private Boolean isEssential;
    private String name;
    private int price;

    public MenuOptionRes(MenuOption menuOption) {
      this.id = menuOption.getId();
      this.isEssential = menuOption.getIsEssential();
      this.name = menuOption.getName();
      this.price = menuOption.getPrice();
    }
  }

}
