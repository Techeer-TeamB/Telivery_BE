package com.telivery.persistence.time.application;

import com.telivery.persistence.time.dao.TimeRepository;
import com.telivery.persistence.time.dto.TimeDTO;
import com.telivery.persistence.time.entity.Time;
import com.telivery.persistence.time.exceptioin.TimeNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TimeService {

  private final TimeRepository timeRepository;

  @Cacheable(value = "restaurant", key = "#id")
  @Transactional(readOnly = true)
  public TimeDTO findOneByRestaurantId(Long restaurantId) {
    Time time = timeRepository.findOneByRestaurantId(restaurantId).orElseThrow(
        TimeNotFoundException::new);
    return new TimeDTO(time);
  }

}
