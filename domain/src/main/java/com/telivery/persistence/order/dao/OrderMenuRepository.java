package com.telivery.persistence.order.dao;

import com.telivery.persistence.order.entity.OrderMenu;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface OrderMenuRepository extends PagingAndSortingRepository<OrderMenu, Long>,
    JpaRepository<OrderMenu, Long> {

  @Query("SELECT om FROM OrderMenu om INNER JOIN om.orderList ol WHERE ol.order.id = ?1")
  List<OrderMenu> findByOrderId(long orderId);

}
