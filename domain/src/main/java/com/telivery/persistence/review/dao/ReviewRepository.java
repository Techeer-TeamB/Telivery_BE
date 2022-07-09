package com.telivery.persistence.review.dao;

import com.telivery.persistence.review.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ReviewRepository extends PagingAndSortingRepository<Review, Long>, JpaRepository<Review, Long> {

  @Query("SELECT count(r.id) FROM Review r WHERE r.restaurant.id = ?1")
  public long countByRestaurantId(Long restaurantId);

}