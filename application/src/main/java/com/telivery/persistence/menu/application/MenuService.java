package com.telivery.persistence.menu.application;

import com.telivery.persistence.menu.dao.MenuRepository;
import com.telivery.persistence.menu.dto.MenuDTO.MenuRes;
import com.telivery.persistence.menu.entity.Menu;
import com.telivery.persistence.menu.exception.MenuIdNotFoundException;
import com.telivery.persistence.menu.exception.NoMenuInRestaurantException;
import com.telivery.persistence.restaurant.application.RestaurantService;
import com.telivery.persistence.restaurant.entity.Restaurant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MenuService {

  private final MenuRepository menuRepository;
  private final RestaurantService restaurantService;

  public Menu findById(long id) {
    Menu menu = menuRepository.findById(id).orElseThrow(MenuIdNotFoundException::new);
    return menu;
  }

  public List<Menu> findByRestaurant(long restaurantId) {
    List<Menu> menuList = menuRepository.findByRestaurant(restaurantId);
    if (menuList.isEmpty()) throw new NoMenuInRestaurantException();
    return menuList;
  }

  public List<MenuRes> findMenuResByRestaurant(long restaurantId) {
    List<Menu> menuList = findByRestaurant(restaurantId);
    return menuList.stream().map(MenuRes::new).collect(Collectors.toList());
  }

}
