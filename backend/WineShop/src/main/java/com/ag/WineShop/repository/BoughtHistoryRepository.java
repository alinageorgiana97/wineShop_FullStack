package com.ag.WineShop.repository;

import com.ag.WineShop.entity.BoughtHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoughtHistoryRepository  extends JpaRepository<BoughtHistory, Integer> {
}
