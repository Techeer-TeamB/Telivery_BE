package com.telivery.persistence.menu.dao;

import com.telivery.persistence.menu.entity.Menu;
import com.telivery.persistence.restaurant.entity.Restaurant;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface MenuRepository extends PagingAndSortingRepository<Menu, Long>,
    JpaRepository<Menu, Long> {

  List<Menu> findByRestaurantId(long restaurantId);

}
