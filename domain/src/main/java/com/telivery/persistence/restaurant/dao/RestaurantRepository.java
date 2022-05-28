package com.telivery.persistence.restaurant.dao;

import com.telivery.persistence.restaurant.entity.Restaurant;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface RestaurantRepository extends PagingAndSortingRepository<Restaurant, Long>,
    JpaRepository<Restaurant, Long> {

  Optional<Restaurant> findById(Long restaurantId);

}
