package com.telivery.persistence.order.application;

import com.telivery.persistence.order.dao.OrderRepository;
import com.telivery.persistence.order.entity.Order;
import com.telivery.persistence.order.exception.IsNotUserOrderException;
import com.telivery.persistence.order.exception.OrderIdNotFoundException;
import com.telivery.persistence.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

  private final OrderRepository orderRepository;

  public Order findById(long orderId) {
    return orderRepository.findById(orderId).orElseThrow(OrderIdNotFoundException::new);
  }

  public Order findByIdAndUser(long orderId, User user) {
    return orderRepository.findByIdAndUser(orderId, user).orElseThrow(IsNotUserOrderException::new);
  }
}
