package com.telivery.persistence.restaurant.application;

import com.telivery.persistence.restaurant.dao.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RestaurantService {

  private final RestaurantRepository restaurantRepository;


}
