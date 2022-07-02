package com.telivery.persistence.menu.dao;

import com.telivery.persistence.menu.entity.MenuOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface MenuOptionRepository extends PagingAndSortingRepository<MenuOption, Long>,
    JpaRepository<MenuOption, Long> {

}
