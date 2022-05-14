package com.telivery.persistence.category.dao;

import com.telivery.persistence.category.entity.Category;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends CrudRepository<Category, Long> {

  List<Category> findAll();

}
