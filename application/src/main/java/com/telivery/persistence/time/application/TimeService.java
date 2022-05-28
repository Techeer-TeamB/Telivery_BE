package com.telivery.persistence.time.application;

import com.telivery.persistence.time.dao.TimeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TimeService {

  private final TimeRepository timeRepository;

  @Transactional(readOnly = true)
  public long countByRestaurantId(Long restaurantId) {
    return timeRepository.countByRestaurantId(restaurantId);
  }

}
