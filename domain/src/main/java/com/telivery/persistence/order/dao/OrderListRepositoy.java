package com.telivery.persistence.order.dao;

import com.telivery.persistence.order.entity.OrderList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface OrderListRepositoy extends PagingAndSortingRepository<OrderList, Long>,
    JpaRepository<OrderList, Long> {

}
