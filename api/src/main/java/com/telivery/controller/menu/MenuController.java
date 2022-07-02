package com.telivery.controller.menu;

import com.telivery.persistence.menu.application.MenuService;
import com.telivery.persistence.menu.dto.MenuDTO.MenuRes;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class MenuController {

  private final MenuService menuService;

  @GetMapping("/restaurant/{restaurantId}/menus")
  public ResponseEntity<List<MenuRes>> findByRestaurant(
      @PathVariable final long restaurantId
  ) {
    return new ResponseEntity<>(menuService.findMenuResByRestaurant(restaurantId), HttpStatus.OK);
  }

}
