package com.telivery.controller.review;

import com.telivery.controller.user.CurrentUser;
import com.telivery.persistence.review.application.ReviewService;
import com.telivery.persistence.review.dto.ReviewDTO.ReviewReq;
import com.telivery.persistence.review.dto.ReviewDTO.ReviewRes;
import com.telivery.persistence.user.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class ReviewController {

  private final ReviewService reviewService;

  @PostMapping(value = "/restaurants/{restaurantId}/orders/{orderId}/review")
  public ResponseEntity<ReviewRes> create(
      @CurrentUser final User user,
      @PathVariable final long restaurantId,
      @PathVariable final long orderId,
      @RequestBody final ReviewReq reviewReq
  ) {
    return new ResponseEntity<>(reviewService.create(user, restaurantId, orderId, reviewReq), HttpStatus.OK);
  }

}
