package com.telivery.controller.category;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telivery.persistence.category.application.CategoryService;
import com.telivery.persistence.category.dto.CategoryDto.CategoryRes;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/categories")
public class CategoryController {

  private final CategoryService categoryService;

  @GetMapping
  public ResponseEntity<CategoryRes> findAll() {
    CategoryRes categoryRes = categoryService.findAll();
    return new ResponseEntity<>(categoryRes, HttpStatus.OK);
  }

}
