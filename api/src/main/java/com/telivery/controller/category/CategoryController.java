package com.telivery.controller.category;

import com.telivery.controller.user.CurrentUser;
import com.telivery.persistence.category.dto.CategoryExampleDto;
import com.telivery.persistence.user.entity.User;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telivery.persistence.category.application.CategoryService;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/categories")
public class CategoryController {

  private final CategoryService categoryService;

  @GetMapping
  public ResponseEntity<List<CategoryExampleDto>> findAll(@CurrentUser User user) {
    System.out.println("로그인 유저 : "+user.getUsername());
    System.out.println("로그인 유저 PK : "+user.getId());

    List<CategoryExampleDto> categoryList = categoryService.findAll();
    return new ResponseEntity<>(categoryList, HttpStatus.OK);
  }

}
