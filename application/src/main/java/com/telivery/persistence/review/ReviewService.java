package com.telivery.persistence.review;

import com.telivery.persistence.review.dao.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ReviewService {

  private final ReviewRepository reviewRepository;

  @Transactional(readOnly = true)
  public long countByRestaurantId(Long customerId) {
    return reviewRepository.countByRestaurantId(customerId);
  }

}
