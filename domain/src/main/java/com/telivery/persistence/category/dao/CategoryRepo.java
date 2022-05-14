package com.telivery.persistence.category.dao;

import com.telivery.persistence.category.dto.CategoryExampleDto;
import com.telivery.persistence.category.entity.Category;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.telivery.persistence.category.dto.CategoryDto.CategoryRes;

@Repository
public interface CategoryRepo extends CrudRepository<Category, Long> {

  List<Category> findAll();

  @Query(value = "SELECT c.id as id, c.name as name from Category c")
  List<CategoryExampleDto> findDto();

}
