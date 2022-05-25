package com.telivery.persistence.time.dao;

import com.telivery.persistence.time.entity.Time;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TimeRepository extends PagingAndSortingRepository<Time, Long>, JpaRepository<Time, Long> {

}
