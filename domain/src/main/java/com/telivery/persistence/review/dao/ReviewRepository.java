package com.telivery.persistence.review.dao;

import com.telivery.persistence.order.entity.Order;
import com.telivery.persistence.review.entity.Review;
import com.telivery.persistence.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ReviewRepository extends PagingAndSortingRepository<Review, Long>, JpaRepository<Review, Long> {

  boolean existsByOrder(Order order);

  @Query("SELECT count(r.id) FROM Review r WHERE r.restaurant.id = ?1")
  public long countByRestaurantId(Long restaurantId);

}
