package com.telivery.persistence.menu.application;

import com.telivery.persistence.menu.dao.MenuOptionRepository;
import com.telivery.persistence.menu.dto.MenuOptionDTO.MenuOptionRes;
import com.telivery.persistence.menu.entity.MenuOption;
import com.telivery.persistence.menu.exception.NoOptionInMenuException;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MenuOptionService {

  private final MenuOptionRepository menuOptionRepository;

  public List<MenuOption> findByMenu(long menuId) {
    List<MenuOption> menuOptionList = menuOptionRepository.findAllByMenuId(menuId);
    if (menuOptionList.isEmpty()) throw new NoOptionInMenuException();
    return menuOptionList;
  }

  public List<MenuOptionRes> findResByMenu(long menuId) {
    List<MenuOption> menuOptionList = findByMenu(menuId);
    return menuOptionList.stream().map(MenuOptionRes::new).collect(Collectors.toList());
  }

}
