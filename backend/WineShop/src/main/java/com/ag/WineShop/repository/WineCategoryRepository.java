package com.ag.WineShop.repository;

import com.ag.WineShop.entity.WineCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface WineCategoryRepository extends JpaRepository<WineCategory,Integer> {
}
