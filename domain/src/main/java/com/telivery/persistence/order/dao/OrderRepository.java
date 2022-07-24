package com.telivery.persistence.order.dao;

import com.telivery.persistence.order.entity.Order;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface OrderRepository extends PagingAndSortingRepository<Order, Long>, JpaRepository<Order, Long> {

  Optional<Order> findByIdAndUserId(long id, long userId);

}
