package com.telivery.persistence.menu.application;

import com.telivery.persistence.menu.dao.MenuRepository;
import com.telivery.persistence.menu.entity.Menu;
import com.telivery.persistence.menu.exception.MenuIdNotFoundException;
import com.telivery.persistence.menu.exception.NoMenuInRestaurantException;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MenuService {

  private final MenuRepository menuRepository;

  public Menu findById(long id) {
    Menu menu = menuRepository.findById(id).orElseThrow(MenuIdNotFoundException::new);
    return menu;
  }

  public List<Menu> findByRestaurant(long restaurantId) {
    List<Menu> menuList = menuRepository.findByRestaurant(restaurantId);
    if (menuList.isEmpty()) throw new NoMenuInRestaurantException();
    return menuList;
  }

}
