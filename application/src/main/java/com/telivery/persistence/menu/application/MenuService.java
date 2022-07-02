package com.telivery.persistence.menu.application;

import com.telivery.persistence.menu.dao.MenuRepository;
import com.telivery.persistence.menu.entity.Menu;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MenuService {

  private final MenuRepository menuRepository;

  public Menu findById (long id) {
    Optional<Menu> menu = menuRepository.findById(id);
  }

}
