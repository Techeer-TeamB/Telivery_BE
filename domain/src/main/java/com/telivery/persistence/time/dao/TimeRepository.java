package com.telivery.persistence.time.dao;

import com.telivery.persistence.time.entity.Time;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TimeRepository extends PagingAndSortingRepository<Time, Long>, JpaRepository<Time, Long> {

 Optional<Time> findOneByRestaurantId(Long restaurantId);

}
