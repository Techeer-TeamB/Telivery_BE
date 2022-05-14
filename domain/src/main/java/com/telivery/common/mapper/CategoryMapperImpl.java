//package com.telivery.common.mapper;
//
//import com.telivery.persistence.category.dto.CategoryDto.CategoryRes;
//import com.telivery.persistence.category.entity.Category;
//import java.util.ArrayList;
//import java.util.List;
//
//public class CategoryMapperImpl implements  CategoryMapper {
//
//  @Override
//  public List<CategoryRes> mapCategoryToRes(List<Category> categoryList) {
//    if (categoryList == null) {
//      return null;
//    }
//
//    List<CategoryRes> list = new ArrayList<>(categoryList.size());
//    for (Category category : categoryList) {
//      list.add(toCategoryRes(category));
//    }
//
//    return list;
//  }
//
//  @Override
//  public CategoryRes toCategoryRes(Category category) {
//    if (category == null) {
//      return null;
//    }
//
//    return CategoryRes.builder()
//        .id(category.getId())
//        .name(category.getName())
//        .build();
//  }
//
//}
