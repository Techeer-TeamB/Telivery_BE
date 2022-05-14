package com.telivery.persistence.category.application;

import com.telivery.persistence.category.dto.CategoryDto.CategoryRes;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

// Transactional 설정 필요

@Service
@RequiredArgsConstructor
public class CategoryService {

  public CategoryRes findAll() {
    return new CategoryRes(1L, "test");
  }

}
