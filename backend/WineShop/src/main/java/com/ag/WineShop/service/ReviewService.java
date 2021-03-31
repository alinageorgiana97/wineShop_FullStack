package com.ag.WineShop.service;

import com.ag.WineShop.dto.ReviewDTO;


import java.util.List;

public interface ReviewService {

    Integer save(ReviewDTO reviewDTO);

    List<ReviewDTO> findAll();
}
