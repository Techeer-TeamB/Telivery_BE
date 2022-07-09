package com.telivery.persistence.order.dao;

import com.telivery.persistence.order.entity.OrderMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface OrderMenuRepository extends PagingAndSortingRepository<OrderMenu, Long>,
    JpaRepository<OrderMenu, Long> {

}
