package com.glowTemp.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.glowTemp.com.entity.FilterDescriptionEntity;

public interface FilterDescRepo extends JpaRepository<FilterDescriptionEntity, Integer> {

}
