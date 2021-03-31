package com.ag.WineShop.repository;


import com.ag.WineShop.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository  extends JpaRepository<Admin, Integer> {
}
