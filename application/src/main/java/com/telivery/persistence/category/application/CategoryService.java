package com.telivery.persistence.category.application;

import com.telivery.common.exception.global.NoDataException;
import com.telivery.persistence.category.dao.CategoryRepo;
import com.telivery.persistence.category.entity.Category;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

// Transactional 설정 필요

@Service
@RequiredArgsConstructor
public class CategoryService {

  private final CategoryRepo categoryRepo;

  public List<Category> findAll() {
    List<Category> categoryList = categoryRepo.findAll();
    if (categoryList.isEmpty()) throw new NoDataException();
    return categoryRepo.findAll();
  }

}
