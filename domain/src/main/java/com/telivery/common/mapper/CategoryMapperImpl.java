package com.telivery.common.mapper;

import com.telivery.persistence.category.dto.CategoryMapperTest;
import com.telivery.persistence.category.entity.Category;
import java.util.ArrayList;
import java.util.List;

public class CategoryMapperImpl implements  CategoryMapper {
  @Override
  public List<CategoryMapperTest> mapCategoryToRes(List<Category> categoryList) {
    if (categoryList == null) {
      return null;
    }

    List<CategoryMapperTest> list = new ArrayList<>(categoryList.size());
    for (Category category : categoryList) {
      list.add(toCategoryMapperTest(category));
    }

    return list;
  }

  @Override
  public CategoryMapperTest toCategoryMapperTest(Category category) {
    if (category == null) {
      return null;
    }

    return CategoryMapperTest.builder()
        .id(category.getId())
        .name(category.getName())
        .build();
  }

}
