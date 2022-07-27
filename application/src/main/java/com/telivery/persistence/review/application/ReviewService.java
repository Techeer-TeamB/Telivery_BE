package com.telivery.persistence.review.application;

import com.telivery.persistence.order.application.OrderService;
import com.telivery.persistence.order.dao.OrderMenuRepository;
import com.telivery.persistence.order.entity.Order;
import com.telivery.persistence.order.entity.OrderMenu;
import com.telivery.persistence.restaurant.application.RestaurantService;
import com.telivery.persistence.restaurant.entity.Restaurant;
import com.telivery.persistence.review.dao.ReviewRepository;
import com.telivery.persistence.review.dto.MyReviewDTO.MyReviewInfo;
import com.telivery.persistence.review.dto.MyReviewDTO.MyReviewRes;
import com.telivery.persistence.review.dto.ReviewDTO.ReviewReq;
import com.telivery.persistence.review.dto.ReviewDTO.ReviewRes;
import com.telivery.persistence.review.entity.Review;
import com.telivery.persistence.review.exception.OrderReviewAlreadyExistsException;
import com.telivery.persistence.review.exception.UserReviewNotFoundException;
import com.telivery.persistence.user.entity.User;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ReviewService {

  private final ReviewRepository reviewRepository;
  private final OrderMenuRepository orderMenuRepository;

  @Transactional(readOnly = true)
  public long countByRestaurantId(Long restaurantId) {
    return reviewRepository.countByRestaurantId(restaurantId);
  }

  public boolean isExistedByOrder(Order order) {
    return reviewRepository.existsByOrder(order);
  }

  public List<Review> findAllByUser(User user) {
    List<Review> reviewList = reviewRepository.findAllByUser(user);
    if (reviewList.isEmpty()) throw new UserReviewNotFoundException();
    return reviewList;
  }

  @Transactional
  public ReviewRes create(User user, Restaurant restaurant, Order order, ReviewReq reviewReq) {
    // DESCRIBE: 요청 주문에 대해 이미 리뷰 남겼는지 확인
    if (isExistedByOrder(order)) throw new OrderReviewAlreadyExistsException();

    // DESCRIBE: 리뷰 생성
    Review review = reviewReq.toEntity(user, restaurant, order);
    reviewRepository.save(review);

    // DESCRIBE: 생성한 리뷰의 평점을 이용, 가게 평점 업데이트
    long reviewCnt = countByRestaurantId(restaurant.getId());
    restaurant.updateScore(review.getScore(), reviewCnt);

    // DESCRIBE: 주문 메뉴 리스트 확인
    List<String> menuList = getOrderMenuList(order.getId());

    return new ReviewRes(review, menuList, restaurant.getScore());
  }

  public List<String> getOrderMenuList(long orderId) {
    List<String> menuList = new ArrayList<>();
    List<OrderMenu> orderMenus = orderMenuRepository.findByOrderId(orderId);
    if (!orderMenus.isEmpty()) menuList = orderMenus.stream().map(OrderMenu::getName).collect(
        Collectors.toList());
    return menuList;
  }

  @Transactional(readOnly = true)
  public List<MyReviewRes> findAllUserReviewRes(User user) {
    List<MyReviewRes> responseList = new ArrayList<>();
    List<Review> reviewList = findAllByUser(user);
    Map<String, List<Review>> dateReviewMap = groupingReviewByDate(reviewList);
    for(Entry<String, List<Review>> entry : dateReviewMap.entrySet()) {
      List<MyReviewInfo> myReviewInfos = getMyReviewList(entry.getValue());
      responseList.add(MyReviewRes.builder().date(entry.getKey()).reviewList(myReviewInfos).build());
    }
    return responseList;
  }

  public Map<String, List<Review>> groupingReviewByDate(List<Review> reviewList) {
    return reviewList.stream().collect(
        Collectors.groupingBy(
            x -> DateTimeFormatter.ofPattern("yyyy-MM-dd").format(x.getCreatedAt()),
            LinkedHashMap::new, Collectors.toList()
        )
    );
  }

  public List<MyReviewInfo> getMyReviewList(List<Review> reviewList) {
    List<MyReviewInfo> myReviewInfoList = new ArrayList<>();
    for (Review review : reviewList) {
      long orderId = review.getOrder().getId();
      String restaurantName = review.getRestaurant().getName();
      List<String> menuList = getOrderMenuList(orderId);
      myReviewInfoList.add(
          MyReviewInfo.builder()
          .review(review)
          .orderList(menuList)
          .restaurantName(restaurantName)
          .build()
      );
    }
    return myReviewInfoList;
  }


}
