package com.ag.WineShop.repository;

import com.ag.WineShop.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository  extends JpaRepository<Review, Integer> {
}
