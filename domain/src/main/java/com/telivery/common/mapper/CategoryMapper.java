package com.telivery.common.mapper;

import com.telivery.persistence.category.dto.CategoryMapperTest;
import com.telivery.persistence.category.entity.Category;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

  CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

  CategoryMapperTest toCategoryMapperTest(Category category);

  List<CategoryMapperTest> mapCategoryToRes(List<Category> categoryList);

}
