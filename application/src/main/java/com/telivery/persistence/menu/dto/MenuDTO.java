package com.telivery.persistence.menu.dto;

import com.telivery.persistence.menu.entity.Menu;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class MenuDTO {

  @Getter
  @NoArgsConstructor(access = AccessLevel.PROTECTED)
  public static class MenuReq {
    // DESCRIBE: 지금 안쓰니까 생략
  }

  @Getter
  @NoArgsConstructor(access = AccessLevel.PROTECTED)
  public static class MenuRes {
    private Long id;
    private String name;
    private String description;
    private int price;
    private String photo;
    private boolean hasOption;

    public MenuRes(Menu menu) {
      this.id = menu.getId();
      this.name = menu.getName();
      this.description = menu.getDescription();
      this.price = menu.getPrice();
      this.photo = menu.getPhoto();
      this.hasOption = menu.getHasOption();
    }
  }

}
