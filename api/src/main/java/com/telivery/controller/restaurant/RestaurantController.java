package com.telivery.controller.restaurant;

import com.telivery.persistence.restaurant.application.RestaurantService;
import com.telivery.persistence.restaurant.dto.RestaurantDTO;
import com.telivery.persistence.restaurant.dto.RestaurantInfoDTO;
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
public class RestaurantController {

  private final RestaurantService restaurantService;

  @GetMapping("/restaurants/{restaurantId}")
  public ResponseEntity<RestaurantDTO> getRestaurantInfo(
      @PathVariable final long restaurantId
  ) {
    return new ResponseEntity<>(restaurantService.getRestaurantInfo(restaurantId), HttpStatus.OK);
  }

  @GetMapping("/categories/{categoryId}/restaurants")
  public ResponseEntity<List<RestaurantInfoDTO>> findRestaurantsByCategory(
      @PathVariable final long categoryId
  ) {
    return new ResponseEntity<>(restaurantService.findRestarurantsByCategory(categoryId), HttpStatus.OK);
  }
}
