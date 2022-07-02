package com.telivery.persistence.bookmark.dao;

import com.telivery.persistence.bookmark.entity.Bookmark;
import com.telivery.persistence.restaurant.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BookmarkRepository extends PagingAndSortingRepository<Bookmark, Long>,
    JpaRepository<Bookmark, Long>  {

}
