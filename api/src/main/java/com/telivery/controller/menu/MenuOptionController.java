package com.telivery.controller.menu;

import com.telivery.persistence.menu.application.MenuOptionService;
import com.telivery.persistence.menu.dto.MenuOptionDTO.MenuOptionRes;
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
public class MenuOptionController {

  private final MenuOptionService menuOptionService;

  @GetMapping("/menu/{menuId}/menu-option")
  public ResponseEntity<List<MenuOptionRes>> findByMenu(
      @PathVariable final long menuId
  ) {
    return new ResponseEntity<>(menuOptionService.findResByMenu(menuId), HttpStatus.OK);
  }

}
